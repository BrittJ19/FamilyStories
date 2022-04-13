package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.Book;
import java.util.ArrayList;
import java.util.List;

public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public List<Book> addBook() {
        List<Book> book = new ArrayList<>();
        String sql = "INSERT INTO books (title, author_name, genre, isbn_id) VALUES ( ?,?,?,?)";
//        jdbcTemplate.update(sql,book.getBookTitle(), book.getAuthorName(), book.getGenre(), book.getIsbn());
        return book;
    };






//    public String findBookByIsbn(String isbnId) {
//        String sql = "SELECT * FROM books WHERE isbn_id = ? ";
//
//    };
//
//    public void findBookByAuthor(String authorName);
//
//    public void findBookByTitle(String title);



}
