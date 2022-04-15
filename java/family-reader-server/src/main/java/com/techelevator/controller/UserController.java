package com.techelevator.controller;


import com.techelevator.dao.AccountDao;
import com.techelevator.dao.FamilyDao;
import com.techelevator.dao.UserDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class UserController {

    private AccountDao accountDao;
    private UserDao userDao;

    public UserController(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(path="/users", method = RequestMethod.GET)
    public List<String> getUsers () {
        return userDao.getUsernameList();
    }

    @RequestMapping(path= "/search={searchTerm}", method = RequestMethod.GET)
    public List<String> searchUsers(@PathVariable ("searchTerm") String searchTerm){
        return userDao.searchUsers(searchTerm);
    }
}
