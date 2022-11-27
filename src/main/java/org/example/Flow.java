package org.example;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Flow {

    public boolean isRunAgain = true;

    public void creatingAccountOrLoggingIn(int selection, User user, Interaction interaction, Library library, File usersFile, Admin admin, File adminsFile) throws IOException {
        Accounts accounts = new Accounts();
        if (selection == 1) {
            accounts.registerUser(user, interaction, selection, library, usersFile);

        } else if (selection == 2) {
            accounts.registerAdmin(admin, interaction, selection, library, usersFile);
        } else if (selection == 3){
            System.out.println("You are logging in as a user");
            interaction.loginUser(selection);
        } else {
            System.out.println("You are logging in as an admin");
            interaction.loginAdmin(selection);
        }
    }

    public void actionsLoop(User user, Interaction interaction, Scanner scanner, Library library, List<Book> bookList, Admin admin) throws IOException {
            if (user != null) {
                interaction.userActionsList();
                int userSelection = scanner.nextInt();
                interaction.checkUserSelection(user, userSelection, library, bookList);
            } else {
                interaction.adminActionsList();
                int adminSelection = scanner.nextInt();
                interaction.checkAdminSelection(admin, adminSelection, library, bookList);
            }
    }
}
