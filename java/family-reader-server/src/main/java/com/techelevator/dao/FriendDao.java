package com.techelevator.dao;

import com.techelevator.model.AddBookForm;
import com.techelevator.model.Book;
import com.techelevator.model.FindFriendForm;
import com.techelevator.model.Friend;

import java.util.List;

public interface FriendDao {


    List<Friend> getFriendList(int friendId);

    boolean createFriend(int userId, FindFriendForm form);


}
