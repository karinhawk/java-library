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
            listOfBooks.add(book.getInfo());
        }
        return listOfBooks;
    }



    public String loanBook(Book book){
        if(!book.isLoaned()) {
            book.setLoaned(true);
            book.setTimesLoaned(book.getTimesLoaned() + 1);
            System.out.println(book.getTimesLoaned());
            booksLoaned.add(book);
            return "You have loaned " + book.getTitle() + " by " + book.getAuthor() + ". Here is your list of currently loaned books: " + getListOfLoanedBooks();

        }
        return "That book is currently unavailable";
    }

    public String returnBook(Book book){
        if(book.isLoaned()){
            book.setLoaned(false);
            System.out.println(book.getTimesLoaned());
            return "You returned " + book.getTitle() + " by " + book.getAuthor() + ". You found it fascinating.";
        }
        return "You can't return something you haven't loaned!";
    }

}
