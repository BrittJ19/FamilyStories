package com.techelevator.model;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private String genre;
    private int pagination;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPagination() {
        return pagination;
    }

    public void setPagination(int pagination) {
        this.pagination = pagination;
    }

<<<<<<< HEAD
    public String getTitle() {
        return title;
=======
    public String getBookTitle() {return bookTitle;
>>>>>>> bdbc371037267620262fc5a59bba7b713535c34e
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
