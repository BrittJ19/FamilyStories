package com.techelevator.controller;

import com.techelevator.dao.AccountDao;
import com.techelevator.dao.FamilyDao;
import com.techelevator.model.Family;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
