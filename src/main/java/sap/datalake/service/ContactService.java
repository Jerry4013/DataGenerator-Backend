package sap.datalake.service;

import sap.datalake.error.BusinessException;
import sap.datalake.model.ContactModel;
import sap.datalake.model.ContactPage;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/04
 **/

public interface ContactService {

    ContactModel createContact(ContactModel contactModel) throws BusinessException;

    ContactModel findById(Integer id);

    ContactModel deleteContact(Integer id);

    void createRandomContacts(Integer amount, Integer accountId) throws BusinessException ;

    ContactPage getContacts(Integer accountId, Integer page);
}
