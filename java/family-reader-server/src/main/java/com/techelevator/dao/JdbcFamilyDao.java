package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.ParentAccount;
import com.techelevator.model.User;
import com.techelevator.model.UserFamily;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFamilyDao implements FamilyDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcFamilyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public boolean createFamily(Family family){
//        boolean userCreated = false;
//
//        // create user
//        String sql = "insert into family (family_name, family_Users, account_id) values(?,?, ?)";
//
//        jdbcTemplate.update(sql, family.getFamilyName(), family.getFamilyUsers(), family.getAccountId() );
//
//        return userCreated;
//
//    }

    @Override
    public List<String> getFamily(int userId, int familyId) {
        User user = null;

        List<String> familyMembers = new ArrayList<>();

        String sql = "SELECT * FROM users JOIN users_family ON users.user_id = users_family.user_id WHERE family_id = ? AND\n" +
                "    users.user_id != ?";

        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql, familyId, userId);

        while(rowset.next()) {
            user = mapRowToUser(rowset);
            familyMembers.add(user.getUsername());
        }
        return familyMembers;
    }

    @Override
    public boolean createFamilyAccount(String familyName, int userId){
        try{
        String sql = "INSERT INTO family (family_name) VALUES (?)";

        jdbcTemplate.update(sql, familyName);

        sql = "INSERT INTO users_family (family_id, user_id) VALUES ((SELECT family_id FROM family WHERE family_name = ?),?)";

        jdbcTemplate.update(sql, familyName, userId);
    } catch (Exception ex) {
            return false;
        }
    return true;
    }

    @Override
    public void createParentAccount(ParentAccount parent, String username) {
        String sql = "INSERT INTO accounts (account_name, account_type, user_id) VALUES (?,?,(SELECT user_id FROM users WHERE username = ?))";
        jdbcTemplate.update(sql, parent.getName(), parent.getType(), username);

    }

    @Override
    public List<Family> getFamilyStats(int userId) {
        List<Family> familyStats = new ArrayList<>();
        String sql = "SELECT * FROM family f JOIN users_family uf ON f.family_id = uf.family_id WHERE uf.user_id = ?";
        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql, userId);

        while(rowset.next()) {
            Family family = new Family();
            family = mapRowToFamily(rowset);
            familyStats.add(family);
        }

        return familyStats;
    }

    @Override
    public List<UserFamily> getFamilyAccounts(int userId) {
        List<UserFamily> familyAccounts = new ArrayList<>();
        String sql= "SELECT user_id, uf.family_id, family_name FROM users_family uf JOIN family f ON f.family_id = uf.family_id WHERE uf.user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while(rowSet.next()) {
            UserFamily family = new UserFamily();
            family = mapRowToUserFamily(rowSet);
            familyAccounts.add(family);
        }
        return familyAccounts;
    }

    @Override
    public boolean addUserToFamily(UserFamily userFamily) {
        try{
        String sql = "INSERT INTO users_family (user_id, family_id) VALUES (?, (SELECT family_id FROM family WHERE family_name = ?))";
        jdbcTemplate.update(sql, userFamily.getUserId(), userFamily.getFamilyName());
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

//    @Override
//    public boolean createParentAccount(UserFamily userFamily) {
//        return false;
//    }

//    @Override
//    public boolean addFamilyMember(String username) {
//        try{
//            String sql= "INSERT into "
//        }
//    }


    public User mapRowToUser (SqlRowSet rowSet) {
        User user = new User();

        user.setId(rowSet.getLong("user_id"));
        user.setUsername(rowSet.getString("username"));
        user.setPassword(rowSet.getString("password_hash"));
        user.setAcccountType(rowSet.getString("account_type"));
        return user;
    }

    private Family mapRowToFamily (SqlRowSet rowSet) {
        Family family = new Family();

        family.setFamilyId(rowSet.getInt("family_id"));
        family.setFamilyName(rowSet.getString("family_name"));
        family.setBooksCompleted(rowSet.getInt("books_completed"));
        family.setPagesRead(rowSet.getInt("pages_read"));
        family.setMoneyEarned(rowSet.getDouble("money_earned"));

        return family;
    }

    private UserFamily mapRowToUserFamily ( SqlRowSet rowSet) {
        UserFamily userFamily = new UserFamily();

        userFamily.setFamilyId(rowSet.getInt("family_id"));
        userFamily.setUserId(rowSet.getInt("user_id"));
        userFamily.setFamilyName(rowSet.getString("family_name"));

        return userFamily;
    }


}
