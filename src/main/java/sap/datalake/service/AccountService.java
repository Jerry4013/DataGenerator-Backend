package sap.datalake.service;

import sap.datalake.model.AccountModel;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/05
 **/

public interface AccountService {

    AccountModel createAccount(AccountModel accountModel);

    AccountModel getAccountById(Integer id);

    List<AccountModel> getAccounts();
}
