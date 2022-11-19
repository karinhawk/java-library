package org.example;

import java.util.List;
import java.util.Scanner;

public class Interaction {
    Scanner scanner = new Scanner(System.in);

    public void welcome(){
        System.out.println("Welcome to Library Online. Please create an account to continue.");
        System.out.println("To create an account, please select 1 or 2.");
        System.out.println("1) I am a user");
        System.out.println("2) I am an admin");
    }

    public String createUsername(int selection){
        if(selection == 1){
            System.out.println("You have chosen: User");
            System.out.println("Please enter a username");
            String username = scanner.nextLine();
            return username;
        }
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
        System.out.println("What would you like to do?");
        System.out.println("1) View list of books in library");
        System.out.println("2) View books I have on loan");
    }

    public void checkUserSelection(int userSelection, Library library, List<Book> bookList){
        if (userSelection == 1) {
            System.out.println("You have selected to view all books in the library");
            library.listAllBooks(bookList);
        } else {
            System.out.println("You have selected to view books you have on loan");
        }
    }
    public void adminActionsList(){
        System.out.println("What would you like to do?");
        System.out.println("1) View list of books in library");
        System.out.println("2) Check library stats");
        System.out.println("3) View list of users");
        System.out.println("4) Run report of loaned books");
    }

    public void checkAdminSelection(int adminSelection, Library library, List<Book> bookList){

        switch (adminSelection){
            case 1:
                System.out.println("you have selected to view all books in the library");
                library.listAllBooks(bookList);
                break;
            case 2:
                System.out.println("you have selected to check library stats");
                break;
            case 3:
                System.out.println("you have selected to view a list of all users");
                break;
            default:
                System.out.println("you have selected to run a report on all loaned books");
                break;
        }
    }

}
