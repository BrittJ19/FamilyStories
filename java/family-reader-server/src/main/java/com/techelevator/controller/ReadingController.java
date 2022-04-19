package com.techelevator.controller;

import com.techelevator.dao.AccountDao;
import com.techelevator.dao.FamilyDao;
import com.techelevator.dao.RecordDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.FamilyForm;
import com.techelevator.model.ReadingLogList;
import com.techelevator.model.ReadingRecord;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController

public class ReadingController {
    private AccountDao accountDao;
    private FamilyDao familyDao;
    private UserDao userDao;
    private RecordDao recordDao;

    public ReadingController(AccountDao accountDao, FamilyDao familyDao, UserDao userDao, RecordDao recordDao) {
        this.accountDao = accountDao;
        this.familyDao = familyDao;
        this.userDao = userDao;
        this.recordDao = recordDao;
    }

    @RequestMapping(path= "/reading/{userId}/record", method = RequestMethod.POST)
    public boolean createReadingRecord(@RequestBody ReadingRecord readingRecord, @PathVariable ("userId") int userId) {
        return recordDao.createRecord(readingRecord, userId);
    }

    @RequestMapping(path="reading/{userId}/pagesRead", method = RequestMethod.GET)
    public int getTotalPagesRead(@PathVariable ("userId") int userId){
        return recordDao.getTotalPagesRead(userId);
    }

    @RequestMapping(path="reading/{userId}/time", method = RequestMethod.GET)
    public int getTotalReadingTime(@PathVariable ("userId") int userId){
        return recordDao.getTotalReadingTime(userId);
    }

    @RequestMapping(path = "reading/{userId}/booksCompleted", method = RequestMethod.GET)
    public int getTotalBooksCompleted(@PathVariable("userId") int userId) {
        return recordDao.getTotalBooksCompleted(userId);
    }

    @RequestMapping(path="/reading/{userId}/moneyDonated", method = RequestMethod.GET)
    public int getTotalFamilyMoneyDonated(@PathVariable ("userId") int userId) {
        return recordDao.getTotalMoneyDonated(userId);
    }

    @RequestMapping(path="/reading/{userId}/moneyEarned", method = RequestMethod.GET)
    public int getTotalFamilyMoneyEarned(@PathVariable ("userId") int userId) {
        return recordDao.getTotalMoneyEarned(userId);
    }

    @RequestMapping(path="/reading/{userId}/logs", method = RequestMethod.GET)
    public List<ReadingLogList> viewReadingActivity(@PathVariable ("userId") int userId) {
        return recordDao.getReadingActivity(userId);
    }
}
