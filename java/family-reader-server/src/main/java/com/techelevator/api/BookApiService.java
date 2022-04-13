package com.techelevator.api;


import com.techelevator.model.Book;

import com.techelevator.util.BasicLogger;
import com.techelevator.util.BasicLoggerException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


@Service
public class BookApiService {
    private static final String API_BASE_URL ="http://localhost:8080/";


    private RestTemplate restTemplate;

    public BookApiService() {this.restTemplate = new RestTemplate();}

    public Book[] getBooks() {
        Book[] books = restTemplate.getForObject(API_BASE_URL +"books", Book[].class);
        return books;
    }

    public String addBook(String bookTitle, String author, String isbn) throws BasicLoggerException {
        Book addBook = new Book();
        addBook.getBookTitle();
        addBook.getAuthorName();
        addBook.getIsbn();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Book> entity = new HttpEntity<>(addBook, headers);

        try {
            String url = restTemplate.postForObject(API_BASE_URL + "/books", entity, String.class);
            return url;
        } catch (RestClientResponseException ex) {
            BasicLogger.log("API Error: " + ex.getRawStatusCode() + " " + ex.getStatusText() +
                    ((ex.getMessage() != null) ? " " + ex.getMessage() : " "));
        } catch (ResourceAccessException ex) {
            BasicLogger.log("API Error: " + ex.getMessage());
        }
        return null;
    }

}
