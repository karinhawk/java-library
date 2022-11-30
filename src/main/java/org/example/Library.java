package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Library {

    private int books;
    private int booksOnLoan;
    private int booksAvailable;
    private Map<String, String> users = new HashMap<>();
    private Map<String, String> admins = new HashMap<>();

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

    public Map<String, String> getUsers() {
        return users;
    }

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }

    public Map<String, String> getAdmins() {
        return admins;
    }

    public void setAdmins(Map<String, String> admins) {
        this.admins = admins;
    }

    public void countBooks(List<Book> booklist){
        System.out.println("The library currently has " + booklist.size() + " books. " + countBooksAvailable(booklist) + " of which are available, and " + countBooksOnLoan(booklist) + " of which are currently on loan.");
    }

    public int countBooksAvailable(List<Book> bookList){
        List<Book> numberOfAvailableBooks = new ArrayList<>();
        for (Book book: bookList){
            if(!book.isLoaned()){
                numberOfAvailableBooks.add(book);
            }
        }
        return numberOfAvailableBooks.size();
    }

    public int countBooksOnLoan(List<Book> bookList){
        List<Book> numberOfLoanedBooks = new ArrayList<>();
        for (Book book: bookList){
            if(book.isLoaned()){
                numberOfLoanedBooks.add(book);
            }
        }
        return numberOfLoanedBooks.size();
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

    public void searchForBook(String title, List<Book> bookList, Scanner scanner, User user) {
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(title)) {
                System.out.println(book.getInfo());
                System.out.println(book.isLoaned());
                if (user.booksLoaned.contains(book)) {
                    System.out.println("You currently have this book on loan. Would you like to return it? Y/N");
                    if (Objects.equals(scanner.nextLine().toLowerCase(), "y")) {
                        user.returnBook(book);
                    } else {
                        System.out.println("Returning to main menu...");
                    }
                } else if (book.isLoaned()){
                    System.out.println("This book is currently unavailable");
                    System.out.println("Returning to main menu...");
                } else {
                    System.out.println("This book is currently available. Would you like to loan it?");
                    if (Objects.equals(scanner.nextLine().toLowerCase(), "y")) {
                        user.loanBook(book);
                    } else {
                        System.out.println("Returning to main menu...");
                    }
                }
            } else {
                continue;
            }
        }
    }

    public void adminSearchBook(String title, List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(title)) {
                System.out.println(book.getInfo());
                System.out.println("This book has been loaned out " + book.getTimesLoaned() + " times");
            }
        }
    }
}
