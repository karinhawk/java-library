package org.example;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File usersFile = new File("src/main/resources/users.json");
        File adminsFile = new File("src/main/resources/admins.json");

        Flow flow = new Flow();
        Interaction interaction = new Interaction();
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        Accounts accounts = new Accounts();
        List<Book> bookList = library.fillBookshelves();

        do{
        interaction.welcome();
        int selection = scanner.nextInt();
        User user = null;
        Admin admin = null;

            Person person = flow.creatingAccountOrLoggingIn(selection, user, interaction, library, usersFile, admin, adminsFile, accounts);

            do {
                interaction.setExit(false);
                flow.actionsLoop(interaction, scanner, library, bookList, person, accounts, usersFile);
            }while(!interaction.isExit());
        } while(flow.isRunAgain);
    }
}