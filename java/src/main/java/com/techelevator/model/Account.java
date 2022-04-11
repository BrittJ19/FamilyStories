package com.techelevator.model;

public class Account {
    private int accountId;
    private String name;
    private String type;
    private int userId;

    public Account(String name, String type, int userId) {
        this.name = name;
        this.type = type;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
