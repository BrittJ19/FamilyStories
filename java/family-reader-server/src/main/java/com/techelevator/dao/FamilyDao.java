package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.ParentAccount;
import com.techelevator.model.User;
import com.techelevator.model.UserFamily;

import javax.validation.constraints.Max;
import java.util.List;

public interface FamilyDao {

    boolean createFamilyAccount(String familyName, int userId);

    public void createParentAccount(ParentAccount parent, String username);

    public List<String> getFamily(int userId, int familyId);

    List<Family> getFamilyStats(int userId);

    List<UserFamily> getFamilyAccounts(int userId);

//    boolean createParentAccount(UserFamily userFamily);

    boolean addUserToFamily(UserFamily userFamily);

//    boolean addFamilyMember(String username);
}
