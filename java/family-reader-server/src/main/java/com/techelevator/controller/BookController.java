package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.AddBookForm;
import com.techelevator.model.Book;
import com.techelevator.model.FamilyForm;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController

public class BookController {
    private UserDao userDao;
    private BookDao bookDao;

    public BookController(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    @RequestMapping(path = "/{userid}/mybooks/addbook", method = RequestMethod.POST)
    public boolean createBook(@PathVariable("userid") int userId, @RequestBody AddBookForm form) {
//        String title = form.getTitle();
//        String author = form.getAuthor();
//        String isbn = form.getIsbn();
//        int userId = form.getUserId();
        return bookDao.createBook(userId,form);
    }

    @RequestMapping(path = "/{userid}/mybooks", method = RequestMethod.GET)
    public List<Book> getBook(@PathVariable("userid") int userId) {
        return bookDao.getBook(userId);
    }
}
