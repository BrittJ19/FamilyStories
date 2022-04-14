package com.techelevator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//to search?
@RestController
@RequestMapping(BookController.API_BASE_URL)
public class BookController {

    public static final String API_BASE_URL = "http://openlibrary.org/search.json";
}
