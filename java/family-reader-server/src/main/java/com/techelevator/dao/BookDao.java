package com.techelevator.dao;

import com.techelevator.model.AddBookForm;
import com.techelevator.model.Book;


import java.util.List;

public interface BookDao {

    boolean createBook(int userId, AddBookForm form);



    List<Book> getBook (int userId);

}
