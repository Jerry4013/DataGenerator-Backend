package sap.datalake.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sap.datalake.dataobject.Contact;
import sap.datalake.dataobject.IaMapping;
import sap.datalake.dataobject.Interaction;
import sap.datalake.error.BusinessException;
import sap.datalake.error.EmBusinessError;
import sap.datalake.model.InteractionModel;
import sap.datalake.model.InteractionPage;
import sap.datalake.model.InteractionVO;
import sap.datalake.repository.ContactJpaRepository;
import sap.datalake.repository.IaMappingJpaRepository;
import sap.datalake.repository.InteractionJpaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/07
 **/
@Service
public class InteractionServiceImpl implements InteractionService {

    private static Random random = new Random();

    @Autowired
    private InteractionJpaRepository interactionJpaRepository;

    @Autowired
    private IaMappingJpaRepository iaMappingJpaRepository;

    @Autowired
    private ContactJpaRepository contactJpaRepository;

    @Override
    @Transactional
    public InteractionModel createInteraction(InteractionModel interactionModel) throws BusinessException {
        if (interactionModel == null) {
            return null;
        }
        if (interactionModel.getIaType() == null || interactionModel.getIaType().equals("") ||
            interactionModel.getCommMedium() == null || interactionModel.getCommMedium().equals("") ||
            interactionModel.getContactId() == null) {
            return null;
        }

        //Check whether ia_type and commMedium are matching.
        List<IaMapping> iaMappings = iaMappingJpaRepository.findAllByIaType(interactionModel.getIaType());
        if (iaMappings == null) {
            return null;
        }
        List<String> commMediums = iaMappings.stream().map(IaMapping::getCommMedium)
                .collect(Collectors.toList());
        if (!commMediums.contains(interactionModel.getCommMedium())) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "Interaction type and " +
                    "communication medium are not matched.");
        }

        Interaction interaction = new Interaction();
        BeanUtils.copyProperties(interactionModel, interaction);
        Interaction save = interactionJpaRepository.save(interaction);
        interactionModel.setInteractionId(save.getInteractionId());
        return interactionModel;
    }

    @Override
    @Transactional
    public InteractionModel deleteInteraction(Integer id) {
        Interaction interaction = interactionJpaRepository.findById(id).orElse(null);
        InteractionModel interactionModel = new InteractionModel();
        if (interaction != null) {
            BeanUtils.copyProperties(interaction, interactionModel);
            interactionJpaRepository.deleteById(id);
        }
        return interactionModel;
    }

    @Override
    public InteractionModel updateInteraction(Integer id) {
        return null;
    }

    @Override
    public InteractionPage getInteractionsByAccountId(Integer id, Integer page) {
        Pageable pageRequest;
        if (page == null || page == 0 || page == 1) {
            pageRequest = PageRequest.of(0, 10);
        } else {
            pageRequest = PageRequest.of(page - 1 , 10);
        }
        Page<Interaction> interactionsPage = interactionJpaRepository.findByAccountId(id, pageRequest);
        return convertFromJpaRawPage(interactionsPage);
    }

    @Override
    public InteractionPage getInteractionsByContactId(Integer id, Integer page) {
        Pageable pageRequest;
        if (page == null || page == 0 || page == 1) {
            pageRequest = PageRequest.of(0, 10);
        } else {
            pageRequest = PageRequest.of(page - 1 , 10);
        }

        Page<Interaction> interactionsPage = interactionJpaRepository.findByContactId(id, pageRequest);
        return convertFromJpaRawPage(interactionsPage);
    }

    private InteractionPage convertFromJpaRawPage(Page<Interaction> interactionsPage) {
        int totalPages = interactionsPage.getTotalPages();
        int totalElements = (int) interactionsPage.getTotalElements();
        int currentPageNumber = interactionsPage.getNumber() + 1;
        int numberOfElements = interactionsPage.getNumberOfElements();

        List<Interaction> interactionList = interactionsPage.getContent();
        List<InteractionVO> interactionVOS = interactionList.stream().map(interaction -> {
            InteractionVO interactionVO = new InteractionVO();
            BeanUtils.copyProperties(interaction, interactionVO);
            Contact contact = contactJpaRepository.findById(interaction.getContactId()).orElse(null);
            interactionVO.setFirstName(contact.getFirstName());
            interactionVO.setLastName(contact.getLastName());
            return interactionVO;
        }).collect(Collectors.toList());

        InteractionPage interactionPage = new InteractionPage(totalPages, totalElements, currentPageNumber,
                numberOfElements, interactionVOS);
        return interactionPage;
    }

    @Override
    public List<InteractionModel> getInteractionsByAccountIdAndStage(Integer accountId, Integer stage) {
        return null;
    }

    @Override
    public void createRandomInteractionsWithAccount(Integer amount, Integer accountId) {

    }

    @Override
    public void createRandomInteractionsWithContact(Integer amount, Integer contactId, Date d1, Date d2,
                                                    Integer iaStage, Integer accountId) {
        if (amount < 1 || amount > 9999) {
            throw new BusinessException(EmBusinessError.EXCEED_MAX_CREATE_LIMIT);
        }
        int count = (int) iaMappingJpaRepository.count();
        List<Interaction> interactionList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int id = random.nextInt(count) + 1;
            IaMapping iaMapping = iaMappingJpaRepository.findById(id).orElse(null);
            Date randomDate = new Date(ThreadLocalRandom.current().nextLong(d1.getTime(), d2.getTime()));
            Interaction interaction = new Interaction(contactId, iaMapping.getCommMedium(), iaMapping.getIaType(),
                    randomDate, iaStage, accountId);
            interactionList.add(interaction);
        }
        ArrayList<Interaction> tempInteractions = new ArrayList<>();
        for (Interaction interaction : interactionList) {
            if (tempInteractions.size() == 300) {
                interactionJpaRepository.saveAll(tempInteractions);
                tempInteractions.clear();
            }
            tempInteractions.add(interaction);
        }
        if (!tempInteractions.isEmpty()) {
            interactionJpaRepository.saveAll(tempInteractions);
        }
    }

    @Override
    public void createRandomInteractionsWithAccountAndStage(Integer amount, Integer accountId, Integer stage) {

    }
}
