package org.example;

import java.util.Objects;

public class Person {

    private String username;
    private String password;
    private int accountID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Person(String username, String password, int accountID) {
        this.username = username;
        this.password = password;
        this.accountID = accountID;
    }
    public boolean isNameMatching(String username){
        return Objects.equals(username, getUsername());
    }

    public boolean isPasswordMatching(String password){
        return Objects.equals(password, getPassword());
    }
}
