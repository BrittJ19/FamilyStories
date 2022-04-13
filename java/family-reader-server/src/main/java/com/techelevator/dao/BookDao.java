package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {
//    public void findBookByIsbn(String isbnId);
//
//    public void findBookByAuthor(String authorName);
//
//    public void findBookByTitle(String title);

    List<Book> addBook(Book book);

}
