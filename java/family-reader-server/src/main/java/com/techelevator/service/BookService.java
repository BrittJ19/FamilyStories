package com.techelevator.service;

import com.techelevator.api.BookApiService;
import com.techelevator.model.Book;
import com.techelevator.util.BasicLogger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;



public class BookService {

    private static final String API_BASE_URL ="http://openlibrary.org/search";

    private RestTemplate restTemplate;

    public BookService() {
        this.restTemplate = new RestTemplate();
    }

    public Book[] getBookMatchingTitle(String title) {
        Book[] books = null;
        try {
            books = restTemplate.getForObject(API_BASE_URL +"?title="+ title, Book[].class);
        } catch (RestClientException e) {
            BasicLogger.log(e.getMessage());
        }
        return books;

    }
    public Book[] getBookByAuthor(String author) {
        Book[] books = null;
        try {
            books = restTemplate.getForObject(API_BASE_URL + "/authors.json?q=" + author, Book[].class);
        } catch (RestClientException e) {
            BasicLogger.log(e.getMessage());
        }
        return books;
    }
    public Book[] getBookByIsbn(String isbn) {
        Book[] books = restTemplate.getForObject(API_BASE_URL + ""+ isbn, Book[].class);
        return books;
    }

}
