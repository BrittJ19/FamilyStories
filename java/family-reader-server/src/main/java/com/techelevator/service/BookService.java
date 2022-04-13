package com.techelevator.service;

import com.techelevator.api.BookApiService;
import com.techelevator.model.Book;
import org.springframework.web.client.RestTemplate;

public class BookService {

    private static final String API_BASE_URL ="http://openlibrary.org";

    private RestTemplate restTemplate;

    public BookService() {
        this.restTemplate = new RestTemplate();
    }

    private Book[] getBooks() {
        Book[] books = restTemplate.getForObject(API_BASE_URL +"books", Book[].class);
        return books;
      
    }
}
