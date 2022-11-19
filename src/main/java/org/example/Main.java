package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.fillBookshelves();
        User user = new User();
        List<Book> bookList = library.fillBookshelves();
                    for (Book book : bookList) {
                System.out.println(book.getInfo());
            }
        System.out.println(user.loanBook(bookList.get(0)));
    }
}