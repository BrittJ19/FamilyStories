package com.techelevator.dao;

import com.techelevator.model.ReadingLogList;
import com.techelevator.model.ReadingRecord;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecordDao implements RecordDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRecordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public boolean createRecord(ReadingRecord readingRecord, int userId) {
        int completeBooks = 0;
//        try{
            if (readingRecord.isCompleted()){
                completeBooks = 1;
            }
            String sql = "INSERT INTO reading_record (user_id, account_type, book_title, format, time, pages_read, completed, notes, date_time) VALUES (?,?,?,?,?,?,?,?, current_timestamp)";

            jdbcTemplate.update(sql, userId, readingRecord.getAccountType(), readingRecord.getBookTitle(), readingRecord.getFormat(), readingRecord.getTimeReading(),
                    readingRecord.getPagesRead(), readingRecord.isCompleted(), readingRecord.getNotes());

            sql = "UPDATE users SET pages_read = pages_read + ? WHERE user_id = ?";

            jdbcTemplate.update(sql, readingRecord.getPagesRead(), userId);

            sql = "UPDATE users SET books_completed = books_completed + ? WHERE user_id = ?";

            jdbcTemplate.update(sql, completeBooks, userId);
//        } catch (Exception ex) {
//            return false;
//        }
        return true;
    }

    @Override
    public int getTotalPagesRead(int userId) {
        int sum = 0;
        String sql = "SELECT * FROM reading_record WHERE user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()){
            ReadingRecord record = mapRowToReadingRecord(rowSet);
            sum += record.getPagesRead();
        }
        return sum;
    }

    public int getTotalReadingTime(int userId) {
        int sum = 0;
        String sql = "SELECT * FROM reading_record WHERE user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()){
            ReadingRecord record = mapRowToReadingRecord(rowSet);
            sum += record.getTimeReading();
        }
        return sum;
    }

    public int getTotalBooksCompleted(int userId) {
        int sum = 0;
        String sql = "SELECT * FROM users WHERE user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()){
            User user = mapRowToUser(rowSet);
            sum += user.getBooksCompleted();
        }
        return sum;
    }

    public int getTotalMoneyEarned(int userId) {
        int sum = 0;
        String sql = "SELECT * FROM users WHERE user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()){
            User user = mapRowToUser(rowSet);
            sum += user.getMoneyEarned();
        }
        return sum;
    }

    public int getTotalMoneyDonated(int userId) {
        int sum = 0;
        String sql = "SELECT * FROM users WHERE user_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()){
            User user = mapRowToUser(rowSet);
            sum += user.getMoneyDonated();
        }
        return sum;
    }

    @Override
    public List<ReadingLogList> getReadingActivity(int userId) {
        List<ReadingLogList> readingActivity = new ArrayList<>();
        String sql = "SELECT record_id, rf.user_id, rf.account_type, book_title, format, time, rf.pages_read, rf.completed, notes, username FROM reading_record rf JOIN " +
        "users u ON rf.user_id = u.user_id WHERE rf.user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while(rowSet.next()){
            ReadingLogList rr = mapRowToReadingLogList(rowSet);
            readingActivity.add(rr);

        }
        return readingActivity;
    }

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
        user.setAccountType(rs.getString("account_type"));
        return user;
    }

    private ReadingRecord mapRowToReadingRecord(SqlRowSet rs){
        ReadingRecord rr = new ReadingRecord();
        rr.setRecordId(rs.getInt("record_id"));
        rr.setUserId(rs.getInt("user_id"));
        rr.setBookTitle(rs.getString("book_title"));
        rr.setFormat(rs.getString("format"));
        rr.setTimeReading(rs.getInt("time"));
        rr.setPagesRead(rs.getInt("pages_read"));
        rr.setCompleted(rs.getBoolean("completed"));
        rr.setNotes(rs.getString("notes"));
        rr.setDateTime(rs.getTimestamp("date_time"));

        return rr;
    }

    private ReadingLogList mapRowToReadingLogList(SqlRowSet rs){
        ReadingLogList rr = new ReadingLogList();
        rr.setRecordId(rs.getInt("record_id"));
        rr.setUserId(rs.getInt("user_id"));
        rr.setBookTitle(rs.getString("book_title"));
        rr.setFormat(rs.getString("format"));
        rr.setTimeReading(rs.getInt("time"));
        rr.setPagesRead(rs.getInt("pages_read"));
        rr.setCompleted(rs.getBoolean("completed"));
        rr.setNotes(rs.getString("notes"));
        rr.setUsername(rs.getString("username"));
        rr.setDateTime(rs.getTimestamp("date_time"));


        return rr;
    }

//    private FamilyMemberStats mapRowToFamilyMemberStats(SqlRowSet rs) {
//        FamilyMemberStats familyMemberStats = new FamilyMemberStats();
//        familyMemberStats.setId(rs.getLong("user_id"));
//        familyMemberStats.setUsername(rs.getString("username"));
//        familyMemberStats.setPassword(rs.getString("password_hash"));
//        familyMemberStats.setActivated(true);
//        familyMemberStats.setBooksCompleted(rs.getInt("books_completed"));
//        familyMemberStats.setPagesRead(rs.getInt("pages_read"));
//        familyMemberStats.setMoneyEarned(rs.getDouble("money_earned"));
//        familyMemberStats.setFamilyName(rs.getString("family_name"));
//        return familyMemberStats;
//    }

}
