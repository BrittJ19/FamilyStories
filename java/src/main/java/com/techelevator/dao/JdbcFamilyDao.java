package com.techelevator.dao;

import com.techelevator.model.Family;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcFamilyDao implements FamilyDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcFamilyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createFamily(Family family){
        boolean userCreated = false;

        // create user
        String sql = "insert into family (name, familyUsers, accountId) values(?,?, ?)";

        jdbcTemplate.update(sql, family.getFamilyName(), family.getFamilyUsers(), family.getAccountId() );

        return userCreated;

    }

//    public List<Account> getFamilyAccountList(Family family){
//
//        String sql = ''
//    }


}
