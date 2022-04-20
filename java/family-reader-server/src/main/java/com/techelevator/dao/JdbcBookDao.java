package com.techelevator.dao;

import com.techelevator.model.AddBookForm;
import com.techelevator.model.Book;
import com.techelevator.model.User;
import com.techelevator.model.UserBook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookDao implements BookDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Transactional
    @Override
    public boolean createBook(int userId, AddBookForm form) {

        try{
            String sql = "INSERT INTO books (author_name, title, isbn) " +
                    "VALUES (?,?,?)";

            jdbcTemplate.update(sql, form.getAuthor(),form.getTitle(), form.getIsbn());

            sql = "INSERT INTO users_books (book_id, user_id) VALUES ((SELECT book_id FROM books WHERE title = ?),?)";

            jdbcTemplate.update(sql, form.getTitle(), userId);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    @Override
    public List<Book> getBook( int userId) {
        Book book = null;

        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books JOIN users_books ON books.book_id = users_books.book_id WHERE users_books.user_id = ?";

        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql, userId);

        while(rowset.next()) {
            book = mapRowToBook(rowset);
            books.add(book);
        }
        return books;

    }
    public User mapRowToUser (SqlRowSet rowSet) {
        User user = new User();

        user.setId(rowSet.getLong("user_id"));
        user.setUsername(rowSet.getString("username"));
        user.setPassword(rowSet.getString("password_hash"));
        user.setAccountType(rowSet.getString("account_type"));
        return user;
    }
    public Book mapRowToBook (SqlRowSet rowSet){
        Book book = new Book();

        book.setBookId(rowSet.getInt("book_id"));
        book.setAuthor(rowSet.getString("author_name"));
        book.setTitle(rowSet.getString("title"));
        book.setIsbn(rowSet.getString("isbn"));

        return book;
    }
    private UserBook mapRowToUserBook (SqlRowSet rowSet) {
        UserBook userBook = new UserBook();

        userBook.setBookId(rowSet.getInt("book_id"));
        userBook.setUserId(rowSet.getInt("user_id"));

        return userBook;
    }

}
