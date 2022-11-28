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
    public static void main(String[] args) throws IOException {
        File usersFile = new File("src/main/resources/users.json");
        File adminsFile = new File("src/main/resources/admins.json");

        Flow flow = new Flow();
        Interaction interaction = new Interaction();
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        Accounts accounts = new Accounts();

        //STORE USERS AS USERNAME, PASSWORD NOT AS JSON OMG

        do{
        List<Book> bookList = library.fillBookshelves();
        interaction.welcome();
        int selection = scanner.nextInt();
        User user = null;
        Admin admin = null;

            Person person = flow.creatingAccountOrLoggingIn(selection, user, interaction, library, usersFile, admin, adminsFile, accounts);

            do {
                interaction.setExit(false);
                flow.actionsLoop(interaction, scanner, library, bookList, person, accounts);
            }while(!interaction.isExit());
        } while(flow.isRunAgain);
    }
}