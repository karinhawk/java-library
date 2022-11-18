package org.example;

import java.util.ArrayList;

public class Book {

    private String name;
    private String author;
    private ArrayList<String> genres;
    private String publisher;
    private boolean onLoan;
    private boolean available;

    private String loanedBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getLoanedBy() {
        return loanedBy;
    }

    public void setLoanedBy(String loanedBy) {
        this.loanedBy = loanedBy;
    }

    public Book() {
    }

    public Book(String name, String author, ArrayList<String> genres, String publisher, boolean onLoan, boolean available, String loanedBy) {
        this.name = name;
        this.author = author;
        this.genres = genres;
        this.publisher = publisher;
        this.onLoan = onLoan;
        this.available = available;
        this.loanedBy = loanedBy;
    }
    public void checkout(){

    }

    public void returnBook(){

    }

    public String getInfo(){
        return getName() + " by " + getAuthor() + " under the genres " + getGenres() + " and published by " + getPublisher();
    }

}
