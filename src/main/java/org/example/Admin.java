package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    public void reportOfBooksOnLoan() {

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
