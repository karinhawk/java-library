package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends Person implements Serializable {

    ArrayList<Book> booksLoaned = new ArrayList<>();

    public User(String username, String password) {
        super(username, password);
    }


    public void getListOfLoanedBooks(){
        if(booksLoaned.isEmpty()){
            System.out.println("You haven't loaned any books yet");
        } else {
            for (Book book : booksLoaned) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }



    public void loanBook(Book book){
        if(!book.isLoaned()) {
            book.setLoaned(true);
            booksLoaned.add(book);
            book.setTimesLoaned(book.getTimesLoaned() + 1);
            System.out.println(book.getTimesLoaned());
            System.out.println("You have loaned " + book.getTitle() + " by " + book.getAuthor());
        } else {
            System.out.println("That book is currently unavailable");
        }
    }

    public void returnBook(Book book){
        if(book.isLoaned()){
            book.setLoaned(false);
            booksLoaned.remove(book);
            System.out.println(book.getTimesLoaned());
            System.out.println("You returned " + book.getTitle() + " by " + book.getAuthor() + ". You found it fascinating.");
        } else {
            System.out.println("You can't return something you haven't loaned!");
        }
    }
}
