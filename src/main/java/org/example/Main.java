package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/main/resources/users.json");
        Map<String, String> listOfUsers = new HashMap<>();


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
            System.out.println(library.getUsers());
            //write to json file here - new user
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            JSONObject jsonUsers = new JSONObject(library.getUsers());
            bw.write(String.valueOf(jsonUsers));
            bw.close();
            fw.close();

        } else if (selection == 2) {
            admin = new Admin(interaction.createUsername(selection), interaction.createPassword(selection), 2, true);
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