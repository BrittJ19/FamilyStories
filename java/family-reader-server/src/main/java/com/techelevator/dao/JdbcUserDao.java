package com.techelevator.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.UserNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer findIdByUsername(String username) {
        if(username == null) throw new IllegalArgumentException("Username cannot be null");

        Integer userId = null;
        try {
            userId = jdbcTemplate.queryForObject("select user_id from users where username = ?", Integer.class, username);

        } catch(EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User " + username + " was not found.");
        }

        if(userId == null) throw new UsernameNotFoundException("User " + username + " was not found.");


        return userId;
    }

	@Override
	public User getUserById(Long userId) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		if(results.next()) {
			return mapRowToUser(results);
		} else {
			throw new UserNotFoundException();
		}
	}

    @Override
    public List<User> getUserByFamilyId(int familyId) {
        List<User> famMembers = new ArrayList<>();
        String sql = "SELECT * FROM users u JOIN users_family uf ON u.user_id = uf.user_id WHERE family_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        while(results.next()) {
            User user = mapRowToUser(results);
            famMembers.add(user);
        }

        return famMembers;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    @Override
    public List<String> getUsernameList() {
        List<String> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE username != 'admin' AND username != 'user'";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while ((results.next())) {
            User user = mapRowToUser(results);
            users.add(user.getUsername());
        }
        return users;
    }

    @Override
    public User findByUsername(String username) {
        if(username == null) throw new IllegalArgumentException("Username cannot be null");

        for (User user : this.findAll()) {
            if( user.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }


    @Override
    public boolean create(String username, String password, String role) {
        boolean userCreated = false;

        // create user
        String insertUser = "insert into users (username,password_hash,role) values(?,?,?)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = role.toUpperCase().startsWith("ROLE") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String id_column = "user_id";
        userCreated = jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(insertUser, new String[]{id_column});
                    ps.setString(1, username);
                    ps.setString(2, password_hash);
                    ps.setString(3, ssRole);
                    return ps;
                }
                , keyHolder) == 1;
        int newUserId = (int) keyHolder.getKeys().get(id_column);

        return userCreated;
    }

    @Override
    public List<String> searchUsers(String searchTerm) {
        searchTerm = searchTerm.toLowerCase();
        List<String> results = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE username LIKE ?";
        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql, "%" + searchTerm + "%");
        while(rowset.next()){
            User user = new User();
            user = mapRowToUser(rowset);
            results.add(user.getUsername());
        }
        return results;
    }



//    private User mapRowToUserTable(SqlRowSet rowset) {
//        User user = new User();
//        user.setId(rowset.getLong("user_id"));
//        user.setUsername(rowset.getString("username"));
//        return user;
//    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(rs.getString("role"));
        user.setActivated(true);
        user.setBooksCompleted(rs.getInt("books_completed"));
        user.setPagesRead(rs.getInt("pages_read"));
        user.setMoneyEarned(rs.getDouble("money_earned"));
        user.setAcccountType(rs.getString("account_type"));
        return user;
    }
}
