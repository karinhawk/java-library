package org.example;

import java.util.Objects;

public class Person {

    private String username;
    private String password;

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


    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean isNameMatching(String username){
        return Objects.equals(username, getUsername());
    }

    public boolean isPasswordMatching(String password){
        return Objects.equals(password, getPassword());
    }
}
