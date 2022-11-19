package org.example;

import java.util.ArrayList;

public class User extends Person {

    private ArrayList<Book> booksLoaned;

    public String loanBook(Book book){
        if(!book.isLoaned()) {
            book.setLoaned(true);
            return "You have loaned " + book.getTitle() + " by " + book.getAuthor();
        }
        return "That book is currently unavailable";
    }

}
