package com.techelevator.dao;

import com.techelevator.model.FamilyMemberStats;
import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(Long userId);

    List<String> getUsernameList();

//    List<String> getUsernameList(int userId);

    User findByUsername(String username);

    Integer findIdByUsername(String username);

    boolean create(String username, String password, String role);

    List<String> searchUsers(String searchTerm);

    List<FamilyMemberStats> getUserByFamilyId(int familyId);
}
