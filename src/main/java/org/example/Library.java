package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private int books;
    private int booksOnLoan;
    private int booksAvailable;
    private List<User> users = new ArrayList<>();
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String countBooks(){
        return "The library currently has " + getBooks() + " books. " + getBooksAvailable() + " of which are available, and " + getBooksOnLoan() + " of which are currently on loan.";
    }

    public List<Book> fillBookshelves(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            List<Book> bookList = mapper.readValue(new File("src/main/resources/books.json"), new TypeReference<List<Book>>() {
            });
            return bookList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> listAllBooks(List<Book> bookList){
        for (Book book : bookList) {
            System.out.println(book.getInfo());
        }
        return bookList;
    }
}
