package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.Book;
import java.util.ArrayList;
import java.util.List;
import com.techelevator.dao.JdbcUserDao;

public class JdbcBookDao{

//    private final JdbcTemplate jdbcTemplate;
//
//    public JdbcBookDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
//
//    public List<Book> addBook(Book book) {
//        List<Book> books = new ArrayList<>();
//        String sql = "INSERT INTO books (title, author_name, genre, isbn_id) VALUES ( ?,?,?,(SELECT user_id FROM users WHERE username = ?))";
//        jdbcTemplate.update(sql, mapRowToBook());
//
//        return books;
//    };
//
//    private Book mapRowToBook(SqlRowSet rs) {
//        Book book = new Book();
//        book.setIsbn(rs.getString("isbn_id"));
//        book.setBookTitle(rs.getString("title"));
//        book.setAuthorName(rs.getString("author_name"));
//        book.setGenre(rs.getString("genre"));
//        return book;
//    }
//
//


//    public String findBookByIsbn(String isbnId) {
//        String sql = "SELECT * FROM books WHERE isbn_id = ? ";
//
//    };
//
//    public void findBookByAuthor(String authorName);
//
//    public void findBookByTitle(String title);



}
