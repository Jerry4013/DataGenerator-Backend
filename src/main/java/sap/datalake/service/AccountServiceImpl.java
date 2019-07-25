package sap.datalake.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sap.datalake.dataobject.Account;
import sap.datalake.model.AccountModel;
import sap.datalake.repository.AccountJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/05
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @Override
    @Transactional
    public AccountModel createAccount(AccountModel accountModel) {
        if (accountModel == null) {
            return null;
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountModel, account);
        Account save = accountJpaRepository.save(account);
        BeanUtils.copyProperties(save, accountModel);
        return accountModel;
    }

    @Override
    public AccountModel getAccountById(Integer id) {
        if (id == null) {
            return null;
        }
        Account account = accountJpaRepository.findById(id).orElse(null);
        AccountModel accountModel = new AccountModel();
        BeanUtils.copyProperties(account, accountModel);
        return accountModel;
    }

    @Override
    public List<AccountModel> getAccounts() {
        List<Account> accountList = accountJpaRepository.findAll();
        List<AccountModel> accountModelList = accountList.stream().map(account -> {
            AccountModel accountModel = new AccountModel();
            BeanUtils.copyProperties(account, accountModel);
            return accountModel;
        }).collect(Collectors.toList());
        return accountModelList;
    }
}
