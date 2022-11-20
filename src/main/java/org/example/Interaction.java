package org.example;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Interaction {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public void welcome(){
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
        }
        System.out.println("---------------------------------------------");
        System.out.println("You have chosen: Admin");
        System.out.println("Please enter a username");
        String username = scanner.nextLine();
        return username;
    }

    public String createPassword(int selection){
        if(selection == 1){
            System.out.println("Please enter a password");
            String username = scanner.nextLine();
            return username;
        }
        System.out.println("Please enter a password");
        String username = scanner.nextLine();
        return username;
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

    public void checkUserSelection(User user, int userSelection, Library library, List<Book> bookList){
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
                System.out.println(user.getListOfLoanedBooks());
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
                admin.getListOfUsers();
                break;
            case 4:
                System.out.println("you have selected to run a report on all loaned books");
                break;
            default:
                wannaExit(scanner);
                break;
        }
    }

    public boolean wannaExit(Scanner scanner){
        System.out.println("Do you wish to log out? Y/N");
        if (Objects.equals(scanner.nextLine().toLowerCase(), "y")){
            setExit(true);
            return exit;
        }
        setExit(false);
        return exit;
    }

}
