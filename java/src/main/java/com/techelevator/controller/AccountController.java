package com.techelevator.controller;

import com.techelevator.dao.AccountDao;
import com.techelevator.dao.FamilyDao;
import com.techelevator.model.Family;
import com.techelevator.model.ParentAccount;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("isAuthenticated()")
@RestController

public class AccountController {
    private AccountDao accountDao;
    private FamilyDao familyDao;

    public AccountController(AccountDao accountDao, FamilyDao familyDao) {
        this.accountDao = accountDao;
        this.familyDao = familyDao;
    }

    @RequestMapping(value = "/family", method = RequestMethod.POST)
    public void addFamily(@RequestBody Family family) {

//            throws AccountNotFoundException{
//        transferService.addTransfer(transfer, accountId);
    }

    @RequestMapping(path= "/family/parentaccount", method = RequestMethod.POST)
    public void addParentAccount(@RequestBody ParentAccount parent) {
        familyDao.createParentAccount(parent);
    }
}
