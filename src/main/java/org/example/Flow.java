package org.example;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Flow {

    public boolean isRunAgain = true;

    public Person creatingAccountOrLoggingIn(int selection, User user, Interaction interaction, Library library, File usersFile, Admin admin, File adminsFile, Accounts accounts) throws IOException {
        if (selection == 1) {
            return accounts.registerUser(interaction, selection, library, usersFile);
        } else if (selection == 2) {
            return accounts.registerAdmin(interaction, selection, library, adminsFile);
        } else if (selection == 3){
            System.out.println("You are logging in as a user");
            return interaction.loginUser();
        } else {
            System.out.println("You are logging in as an admin");
            return interaction.loginAdmin();
        }
    }

    public void actionsLoop(Interaction interaction, Scanner scanner, Library library, List<Book> bookList, Person person, Accounts accounts, File usersFile) throws IOException {
            if (!person.isAdmin()) {
                User user = (User) person;
                interaction.userActionsList();
                int userSelection = scanner.nextInt();
                interaction.checkUserSelection(user, userSelection, library, bookList);
            } else {
                Admin admin = (Admin) person;
                interaction.adminActionsList();
                int adminSelection = scanner.nextInt();
                interaction.checkAdminSelection(admin, adminSelection, library, bookList);
            }
    }
}
