package sap.datalake.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sap.datalake.dataobject.Account;
import sap.datalake.dataobject.Contact;
import sap.datalake.dataobject.Interaction;
import sap.datalake.error.BusinessException;
import sap.datalake.error.EmBusinessError;
import sap.datalake.model.AccountModel;
import sap.datalake.model.ContactModel;
import sap.datalake.model.ContactPage;
import sap.datalake.repository.AccountJpaRepository;
import sap.datalake.repository.ContactJpaRepository;
import sap.datalake.utils.RandomContactGenerator;
import sap.datalake.validator.ValidationResult;
import sap.datalake.validator.ValidatorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/04
 **/
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactJpaRepository contactJpaRepository;

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @Autowired
    private ValidatorImpl validator;

    @Transactional
    public ContactModel createContact(ContactModel contactModel) throws BusinessException {
        if (contactModel == null) {
            return null;
        }
        ValidationResult validationResult = validator.validate(contactModel);
        if (validationResult.isHasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,validationResult.getErrMsg());
        }
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactModel,contact);
        Account account = new Account();
        BeanUtils.copyProperties(contactModel.getAccount(), account);
        contact.setAccount(account);
        Contact save = contactJpaRepository.save(contact);
        BeanUtils.copyProperties(save, contactModel);
        return contactModel;
    }

    public ContactModel findById(Integer id) {
        Contact contact = contactJpaRepository.findById(id).orElse(null);
        ContactModel contactModel = new ContactModel();
        BeanUtils.copyProperties(contact, contactModel);
        return contactModel;
    }

    @Override
    @Transactional
    public ContactModel deleteContact(Integer id) {
        Contact contact = contactJpaRepository.findById(id).orElse(null);
        contactJpaRepository.deleteById(id);
        ContactModel contactModel = new ContactModel();
        BeanUtils.copyProperties(contact, contactModel);
        return contactModel;
    }

    @Override
    @Transactional
    public void createRandomContacts(Integer amount, Integer accountId) throws BusinessException {
        if (amount == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "No amount is specified.");
        } else if (amount > 9999) {
            throw new BusinessException(EmBusinessError.EXCEED_MAX_CREATE_LIMIT);
        } else if (amount < 0) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "Cannot create negative number of" +
                    " contacts.");
        }
        Account account = accountJpaRepository.findById(accountId).orElse(null);
        List<ContactModel> contactModels = RandomContactGenerator.generateContacts(amount);
        List<Contact> contacts = contactModels.stream().map(contactModel -> {
            Contact contact = new Contact();
            BeanUtils.copyProperties(contactModel, contact);
            contact.setAccount(account);
            return contact;
        }).collect(Collectors.toList());

        ArrayList<Contact> tempContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (tempContacts.size() == 300) {
                contactJpaRepository.saveAll(tempContacts);
                tempContacts.clear();
            }
            tempContacts.add(contact);
        }
        if (!tempContacts.isEmpty()) {
            contactJpaRepository.saveAll(tempContacts);
        }
    }

    @Override
    public ContactPage getContacts(Integer accountId, Integer page) {
        Pageable pageRequest = (page == null || page == 0 || page == 1) ? PageRequest.of(0, 10) :
                PageRequest.of(page - 1 , 10);
        Page<Contact> contactPageRaw = contactJpaRepository.findAllByAccountAccountId(accountId, pageRequest);
        int totalPages = contactPageRaw.getTotalPages();
        int totalElements = (int) contactPageRaw.getTotalElements();
        int currentPageNumber = contactPageRaw.getNumber() + 1;
        int numberOfElements = contactPageRaw.getNumberOfElements();

        List<Contact> contactList = contactPageRaw.getContent();
        List<ContactModel> contactModelList = contactList.stream().map(contact -> {
            ContactModel contactModel = new ContactModel();
            BeanUtils.copyProperties(contact, contactModel);
            Account account = accountJpaRepository.findById(accountId).orElse(null);
            AccountModel accountModel = new AccountModel();
            BeanUtils.copyProperties(account, accountModel);
            contactModel.setAccount(accountModel);
            return contactModel;
        }).collect(Collectors.toList());

        ContactPage contactPage = new ContactPage(totalPages, totalElements, currentPageNumber,
                numberOfElements, contactModelList);
        return contactPage;
    }
}
