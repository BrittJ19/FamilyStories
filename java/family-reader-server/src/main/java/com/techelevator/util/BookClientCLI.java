package com.techelevator.util;

import com.techelevator.api.BookApiService;
import com.techelevator.model.Book;

import java.util.Scanner;

public class BookClientCLI {

    private final BookApiService apiService;
    private Scanner scanner;
    private Book[] books;

    public BookClientCLI(BookApiService apiService) {
        this.apiService = apiService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        books = apiService.getBooks();
    }
}
