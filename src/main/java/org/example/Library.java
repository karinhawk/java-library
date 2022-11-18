package org.example;

import java.util.ArrayList;

public class Library {

    private int books;
    private int booksOnLoan;
    private int booksAvailable;
    private ArrayList<User> users;
    //where all the books are stored


    public int getBooks() {
        return books;
    }

    public void setBooks(int books) {
        this.books = books;
    }

    public int getBooksOnLoan() {
        return booksOnLoan;
    }

    public void setBooksOnLoan(int booksOnLoan) {
        this.booksOnLoan = booksOnLoan;
    }

    public int getBooksAvailable() {
        return booksAvailable;
    }

    public void setBooksAvailable(int booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String countBooks(){
        return "The library currently has " + getBooks() + " books. " + getBooksAvailable() + " of which are available, and " + getBooksOnLoan() + " of which are currently on loan.";
    }
}
