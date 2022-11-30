package org.example;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Admin extends Person {


    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }


    public int timesLoanedOut(Book book) {
        return book.getTimesLoaned();
    }

    public void getListOfUsers(Accounts accounts) throws IOException {
        Map usersMap = accounts.getUsersFromFile();
        usersMap.forEach((key, value) -> {
            System.out.println(key);
        });
    }

    public void runReport(List<Book> bookList) {
        System.out.println("REPORT OF ALL BOOKS CURRENTLY ON LOAN");
        for (Book book: bookList) {
            if(book.isLoaned()){
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}
