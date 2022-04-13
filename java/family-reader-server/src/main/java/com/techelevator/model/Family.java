package com.techelevator.model;

import java.util.List;

public class Family {
    private int familyId;
    private String familyName;
    private List<User> familyUsers;
    private int accountId;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<User> getFamilyUsers() {
        return familyUsers;
    }

    public void setFamilyUsers(List<User> familyUsers) {
        this.familyUsers = familyUsers;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
