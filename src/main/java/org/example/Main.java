package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        File usersFile = new File("src/main/resources/users.json");
        File adminsFile = new File("src/main/resources/admins.json");

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
            library.getUsers().put(user.getUsername(), user.getPassword());

            FileWriter usersFw = new FileWriter(usersFile.getAbsoluteFile(), true);
            BufferedWriter usersBw = new BufferedWriter(usersFw);
            JSONObject jsonUsers = new JSONObject(library.getUsers());

            usersBw.write(String.valueOf(jsonUsers));
            usersBw.close();
            usersFw.close();

        } else if (selection == 2) {
            admin = new Admin(interaction.createUsername(selection), interaction.createPassword(selection), 2, true);
            library.getAdmins().put(admin.getUsername(), admin.getPassword());

            FileWriter adminsFw = new FileWriter(adminsFile.getAbsoluteFile(), true);
            BufferedWriter adminsBw = new BufferedWriter(adminsFw);
            JSONObject jsonAdmins = new JSONObject(library.getAdmins());

            adminsBw.write(String.valueOf(jsonAdmins));
            adminsBw.close();
            adminsFw.close();
        } else if (selection == 3){
            System.out.println("You are logging in as a user");
            interaction.loginUser(selection);
        } else {
            System.out.println("You are logging in as an admin");
            interaction.loginAdmin(selection);
        }
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
        } while (!interaction.isExit());
    }
}