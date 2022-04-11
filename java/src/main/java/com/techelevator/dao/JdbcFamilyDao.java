package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.ParentAccount;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcFamilyDao implements FamilyDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcFamilyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createFamily(Family family){
        boolean userCreated = false;

        // create user
        String sql = "insert into family (family_name, family_Users, account_id) values(?,?, ?)";

        jdbcTemplate.update(sql, family.getFamilyName(), family.getFamilyUsers(), family.getAccountId() );

        return userCreated;

    }

//    public List<Account> getFamilyAccountList(Family family){
//
//        String sql = ''
//    }
    @Override
    public void createParentAccount(ParentAccount parent) {
        String sql = "INSERT INTO accounts (account_name, account_type, user_id) VALUES (?,?, ?)";
        jdbcTemplate.update(sql, parent.getName(), parent.getType(), parent.getUserId());

    }
}
