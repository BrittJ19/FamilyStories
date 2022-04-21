package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.FamilyMemberStats;
import com.techelevator.model.Friend;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class FriendController {
    private UserDao userDao;
    private FriendDao friendDao;

    public FriendController( UserDao userDao,FriendDao friendDao) {
        this.friendDao = friendDao;
        this.userDao = userDao;
    }

    @RequestMapping(path= "/{userId}/myFriends", method = RequestMethod.GET)
    public List<Friend> getFriendList(@PathVariable("friendId") int friendId) {
        return friendDao.getFriendList(friendId);
    }


}
