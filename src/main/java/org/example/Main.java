package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Library library = new Library();
//        library.fillBookshelves();

        //1. welcome to Library. please create an account
        //2. Are you a user or an admin
        //3. choice if else - if user then User user, if admin then Admin admin
        //4. ask for username and password - ask for password to loan book??? error handling for credentials
        //5. you have successfully created account!
        //6. IF USER what would you like to do? choose from: See list of books; Loan a book; return a book; see loaned books
        //see list of books = library.listOfBooks
        //loan a book = user.


        //IF ADMIN = see list of users; run report of loaned books; see loan log of particular book
        //see list of books - can then choose book and see how many times it has been loaned
        //see list of users = display arraylist of users
        //run report in csv format - have long method for this :) - take list of all books which isLoaned - all info of

        Interaction interaction = new Interaction();
        Library library = new Library();
        List<Book> bookList = library.fillBookshelves();
        Scanner scanner = new Scanner(System.in);
        interaction.welcome();
        int selection = scanner.nextInt();
        User user = null;
        Admin admin = null;
        if (selection == 1) {
            user = new User(interaction.createUsername(selection), interaction.createPassword(selection), 1);
            library.getUsers().add(user);
        } else if (selection == 2) {
            admin = new Admin(interaction.createUsername(selection), interaction.createPassword(selection), 2, true);
        }
        interaction.isExit();
        do {
            if (user != null) {
                interaction.userActionsList();
                int userSelection = scanner.nextInt();
                interaction.checkUserSelection(user, userSelection, library, bookList);
            } else {
                interaction.adminActionsList();
                int adminSelection = scanner.nextInt();
                interaction.checkAdminSelection(admin, adminSelection, library, bookList);
            }
            interaction.wannaExit(scanner);
        } while (!interaction.isExit());
//        System.out.println(user.loanBook(bookList.get(0)));
//        System.out.println(user.returnBook(bookList.get(0)));
    }
}