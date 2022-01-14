package com.company.Objects;

public class Book {
    private String bookTitle;
    private String AuthorName;
    private String Genre;
    private String ISBN;

    public Book(String bookTitle, String authorName, String genre, String ISBN) {
        this.bookTitle = bookTitle;
        AuthorName = authorName;
        Genre = genre;
        this.ISBN = ISBN;
    }

    public String toString(){
        return bookTitle + "- " + AuthorName + "- " + Genre + "- " + ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
