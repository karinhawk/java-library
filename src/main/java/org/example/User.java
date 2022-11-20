package org.example;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    ArrayList<Book> booksLoaned = new ArrayList<>();

    public User(String username, String password, int accountID) {
        super(username, password, accountID);
    }


    public List<String> getListOfLoanedBooks(){
        List<String> listOfBooks = new ArrayList<>();
        for (Book book: booksLoaned) {
            listOfBooks.add(book.getTitle());
        }
        return listOfBooks;
    }



    public void loanBook(Book book){
        if(!book.isLoaned()) {
            book.setLoaned(true);
            booksLoaned.add(book);
            book.setTimesLoaned(book.getTimesLoaned() + 1);
            System.out.println(book.getTimesLoaned());
            System.out.println("You have loaned " + book.getTitle() + " by " + book.getAuthor() + ". Here is your list of currently loaned books: " + getListOfLoanedBooks());

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
