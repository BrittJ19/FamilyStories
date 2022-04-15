package com.techelevator.model;

import java.math.BigDecimal;

public class Family {
    private int familyId;
    private String familyName;
    private int booksCompleted = 0;
    private int pagesRead = 0;
    private double moneyEarned = 0.0;

    public int getBooksCompleted() {
        return booksCompleted;
    }

    public void setBooksCompleted(int booksCompleted) {
        this.booksCompleted = booksCompleted;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

}
