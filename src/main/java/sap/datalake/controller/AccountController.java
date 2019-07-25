package sap.datalake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sap.datalake.error.BusinessException;
import sap.datalake.error.EmBusinessError;
import sap.datalake.model.AccountModel;
import sap.datalake.response.CommonReturnType;
import sap.datalake.service.AccountService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/05
 **/
@RestController
@RequestMapping("/account")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/create")
    public CommonReturnType createAccount(@RequestBody @Valid AccountModel accountModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "Company name cannot be empty.");
        }
        AccountModel account = accountService.createAccount(accountModel);
        return CommonReturnType.create(account);
    }

    @GetMapping(value = "/getAccounts")
    public CommonReturnType getAccounts() {
        List<AccountModel> accounts = accountService.getAccounts();
        return CommonReturnType.create(accounts);
    }

    @GetMapping(value = "/getAccount")
    public CommonReturnType getAccount(@RequestParam("accountid") Integer accountId) {
        AccountModel account = accountService.getAccountById(accountId);
        return CommonReturnType.create(account);
    }

}
