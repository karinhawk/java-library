package org.example;

import java.io.*;
import java.util.*;

public class Interaction {
    Scanner scanner = new Scanner(System.in);

    Accounts accounts = new Accounts();

    private boolean exit = false;

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    private boolean loggedIn;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void welcome(){
        System.out.println(" __    __ ____  ____   ___  ____  _  _      ___   __  __ __    __ __  __  ____\n" +
                " ||    || || )) || \\\\ // \\\\ || \\\\ \\\\//     // \\\\  ||\\ || ||    || ||\\ || ||   \n" +
                " ||    || ||=)  ||_// ||=|| ||_//  )/     ((   )) ||\\\\|| ||    || ||\\\\|| ||== \n" +
                " ||__| || ||_)) || \\\\ || || || \\\\ //       \\\\_//  || \\|| ||__| || || \\|| ||___");
        System.out.println("Welcome to Library Online. Please login or create an account to continue.");
        System.out.println("---------------------------------------------");
        System.out.println("To create an account, please select 1 or 2.");
        System.out.println("1) I am a user");
        System.out.println("2) I am an admin");
        System.out.println("To login, please select 3 or 4");
        System.out.println("3) Login as user");
        System.out.println("4) Login as admin");
    }

    public String createUsername(int selection){
        if(selection == 1){
            System.out.println("---------------------------------------------");
            System.out.println("You have chosen: User");
            System.out.println("Please enter a username");
            String username = scanner.nextLine();
            return username;
        } else if (selection == 2) {
            System.out.println("---------------------------------------------");
            System.out.println("You have chosen: Admin");
            System.out.println("Please enter a username");
            String username = scanner.nextLine();
            return username;
        }
        return null;
    }

    public String createPassword(int selection){
        if(selection == 1){
            System.out.println("Please enter a password");
            String username = scanner.nextLine();
            return username;
        } else if (selection == 2) {
            System.out.println("Please enter a password");
            String username = scanner.nextLine();
            return username;
        }
        return null;
    }

    public Admin loginAdmin(Interaction interaction) throws IOException {
        Map adminsMap = accounts.getAdminsFromFile();
        setLoggedIn(false);
        do {
            System.out.println("Enter your username");
            String usernameInput = scanner.nextLine();
            String password = accounts.grabAdminUsername(usernameInput, adminsMap);
            if (password == null) {
                System.out.println("That admin username doesn't seem to exist. Please try again.");
            }
            System.out.println("Please enter your password");
            String passwordInput = scanner.nextLine();
            return accounts.adminPasswordCorrect(passwordInput, password, usernameInput, interaction);
        }while(!loggedIn);
    }

    public User loginUser(Interaction interaction) throws IOException {
        Map usersMap = accounts.getUsersFromFile();
        setLoggedIn(false);
        do {
            System.out.println("Enter your username");
            String usernameInput = scanner.nextLine();
            String password = accounts.grabUserUsername(usernameInput, usersMap);
            if (password == null) {
                System.out.println("That user username doesn't seem to exist. Please try again.");
            }
            System.out.println("Please enter your password");
            String passwordInput = scanner.nextLine();
            return accounts.userPasswordCorrect(passwordInput, password, usernameInput, interaction);
        }while (!loggedIn);
    }

    public void userActionsList(){
        System.out.println("---------------------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1) View list of books in library");
        System.out.println("2) Search for a book to loan/return");
        System.out.println("3) View books I have on loan");
        System.out.println("4) Log out");
        System.out.println("---------------------------------------------");
    }

    public void checkUserSelection(User user, int userSelection, Library library, List<Book> bookList) throws FileNotFoundException {
        switch (userSelection){
            case 1:
            System.out.println("You have selected to view all books in the library");
            System.out.println("---------------------------------------------");
            library.listAllBooks(bookList);
            break;
            case 2:
                System.out.println("You have selected to search for a specific book. Please type in the Title:");
                String title = scanner.nextLine();
                library.searchForBook(title, bookList, scanner, user);
            break;
            case 3:
                System.out.println("You have selected to view books you have on loan");
                System.out.println("---------------------------------------------");
                System.out.println("Your currently loaned books:");
                user.getListOfLoanedBooks();
                break;
            default:
                wannaExit(scanner);
                break;
        }
    }
    public void adminActionsList(){
        System.out.println("---------------------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1) View list of books in library");
        System.out.println("2) Check library stats");
        System.out.println("3) View list of users");
        System.out.println("4) Run report of loaned books");
        System.out.println("5) Log out");
        System.out.println("---------------------------------------------");
    }

    public void checkAdminSelection(Admin admin, int adminSelection, Library library, List<Book> bookList) throws IOException {

        switch (adminSelection){
            case 1:
                System.out.println("you have selected to view all books in the library");
                library.listAllBooks(bookList);
                break;
            case 2:
                System.out.println("you have selected to check library stats");
                library.countBooks(bookList);
                break;
            case 3:
                System.out.println("you have selected to view a list of all users");
                admin.getListOfUsers(accounts);
                break;
            case 4:
                System.out.println("you have selected to run a report on all loaned books");
                admin.runReport(bookList);
                break;
            default:
                wannaExit(scanner);
                break;
        }
    }

    public boolean wannaExit(Scanner scanner) throws FileNotFoundException {
        System.out.println("Do you wish to log out? Y/N");
        if (Objects.equals(scanner.nextLine().toLowerCase(), "y")){
            setExit(true);
            return exit;
        }
        setExit(false);
        return exit;
    }

}
