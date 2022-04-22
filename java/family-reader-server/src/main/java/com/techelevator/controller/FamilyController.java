package com.techelevator.controller;

import com.techelevator.dao.AccountDao;
import com.techelevator.dao.FamilyDao;
import com.techelevator.model.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController

public class FamilyController {
    private AccountDao accountDao;
    private FamilyDao familyDao;

    public FamilyController(AccountDao accountDao, FamilyDao familyDao) {
        this.accountDao = accountDao;
        this.familyDao = familyDao;
    }

    @RequestMapping(value = "/family", method = RequestMethod.POST)
    public void addFamily(@RequestBody Family family) {

//            throws AccountNotFoundException{
//        transferService.addTransfer(transfer, accountId);
    }

    @RequestMapping(path= "/family/addMember", method = RequestMethod.POST)
    public boolean addUserToFamily(@RequestBody  UserFamily userFamily) {
        return familyDao.addUserToFamily(userFamily);
    }

//    @RequestMapping(path= "/family", method = RequestMethod.GET)
//    public List<User> getFamily () {
//       return familyDao.getFamily();
//    }

    @RequestMapping(path= "/family/newAccount", method = RequestMethod.POST)
    public boolean createFamilyAccount(@RequestBody FamilyForm form) {
        String familyName = form.getFamilyName();
        int userId = form.getUserId();
        return familyDao.createFamilyAccount(familyName, userId);
    }

    @RequestMapping(path="/family/{userId}/{familyId}", method = RequestMethod.GET)
    public List<String> getFamilyMembers(@PathVariable("userId") int userId, @PathVariable("familyId") int familyId) {
        return familyDao.getFamily(userId, familyId);
    }

    @RequestMapping(path="/familyStats/{userId}", method = RequestMethod.GET)
    public List<Family> getFamilyStats(@PathVariable("userId") int userId) {
        return familyDao.getFamilyStats(userId);
    }

    @RequestMapping(path="/family/{userId}/accounts", method = RequestMethod.GET)
    public List<UserFamily> getFamilyAccounts(@PathVariable("userId") int userId) {
        return familyDao.getFamilyAccounts(userId);
    }
//    @RequestMapping(path="/family/{userId}/childAccounts", method = RequestMethod.GET)
//    public List<UserFamily>

    @RequestMapping(path="/family/{familyId}/pagesRead", method = RequestMethod.GET)
    public int getTotalFamilyPages(@PathVariable ("familyId") int familyId) {
        return familyDao.getFamilyPages(familyId);
    }

    @RequestMapping(path="/family/{familyId}/booksCompleted", method = RequestMethod.GET)
    public int getTotalFamilyBooksCompleted(@PathVariable ("familyId") int familyId) {
        return familyDao.getFamilyBooksCompleted(familyId);
    }

    @RequestMapping(path="/family/{familyId}/moneyEarned", method = RequestMethod.GET)
    public double getTotalFamilyMoneyEarned(@PathVariable ("familyId") int familyId) {
        return familyDao.getFamilyMoneyEarned(familyId);
    }

    @RequestMapping(path="/family/{familyId}/moneyDonated", method = RequestMethod.GET)
    public double getTotalFamilyMoneyDonated(@PathVariable ("familyId") int familyId) {
        return familyDao.getFamilyMoneyDonated(familyId);
    }

//    @RequestMapping(path="/family/addMember/{username}", method = RequestMethod.POST)
//    public boolean addFamilyMember(@PathVariable("username") String username) {
//        return familyDao.addFamilyMember(username);
//    }


}
