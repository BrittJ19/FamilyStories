package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcFriendDao implements FriendDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcFriendDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Transactional

    public boolean createFriend(int userId, FindFriendForm form) {

        try{
            String sql = "INSERT INTO friends (nickname,username) VALUES (?,?);";

            jdbcTemplate.update(sql ,form.getUsername());

            sql ="INSERT INTO users_friends (friend_id, user_id, username) VALUES ((SELECT friend_id FROM friends WHERE username = ?),(select user_id from users where username = ? ),\n" +
                    "(SELECT username FROM friends WHERE username = ?));";

            jdbcTemplate.update(sql, form.getUsername());
        } catch (Exception ex) {
            return false;
        }
        return true;
    }



    public List<Friend> getFriendList(int userId) {
        Friend friend = null;

        List<Friend> friends = new ArrayList<>();

        String sql = "SELECT * FROM friends JOIN users_friends ON friends.friend_id = users_friends.friend_id WHERE users_friends.user_id = ?";

        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql, userId);

        while(rowset.next()) {
            friend = mapRowToFriend(rowset);
            friends.add(friend);
        }
        return friends;

    }
    public User mapRowToUser (SqlRowSet rowSet) {
        User user = new User();

        user.setId(rowSet.getLong("user_id"));
        user.setUsername(rowSet.getString("username"));
        user.setPassword(rowSet.getString("password_hash"));
        user.setAccountType(rowSet.getString("account_type"));
        return user;
    }
    public Friend mapRowToFriend (SqlRowSet rowSet){
        Friend friend = new Friend();

      friend.setFriendId(rowSet.getInt("friend_id"));
        friend.setNickname(rowSet.getString("nickname"));
        friend.setUserId(rowSet.getString("user_id"));
        friend.setUsername(rowSet.getString("username"));

        return friend;
    }
    private UserFriend mapRowToUserFriend (SqlRowSet rowSet) {
        UserFriend userFriend = new UserFriend();

        userFriend.setFriendId(rowSet.getInt("friend_id"));
        userFriend.setUserId(rowSet.getInt("user_id"));

        return userFriend;
    }


}
