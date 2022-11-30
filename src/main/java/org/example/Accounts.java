package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Accounts {

    private String chosenPerson;

    public String getChosenPerson() {
        return chosenPerson;
    }

    public void setChosenPerson(String chosenPerson) {
        this.chosenPerson = chosenPerson;
    }


    public User registerUser(Interaction interaction, int selection, Library library, File usersFile) throws IOException {
        User user = new User(interaction.createUsername(selection), interaction.createPassword(selection));

        FileWriter usersFw = new FileWriter(usersFile.getAbsoluteFile(), true);
        BufferedWriter usersBw = new BufferedWriter(usersFw);
        String userString = user.getUsername() + ", " + user.getPassword();
        usersBw.newLine();
        usersBw.write(userString);
        usersBw.close();
        usersFw.close();
        return user;
    }

    public Admin registerAdmin(Interaction interaction, int selection, Library library, File adminsFile) throws IOException {
        Admin admin = new Admin(interaction.createUsername(selection), interaction.createPassword(selection));

        FileWriter adminsFw = new FileWriter(adminsFile.getAbsoluteFile(), true);
        BufferedWriter adminsBw = new BufferedWriter(adminsFw);
        String adminString = admin.getUsername() + ", " + admin.getPassword();

        adminsBw.newLine();
        adminsBw.write(adminString);
        adminsBw.close();
        adminsFw.close();
        return admin;
    }

    public Map<String, String> getAdminsFromFile() throws IOException {
        InputStream is = new FileInputStream("src/main/resources/admins.json");
        Map<String, String> adminsMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] values = line.split(", ");
                String username = values[0];
                String password = values[1];
                adminsMap.put(username, password);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adminsMap;
    }


    public String grabAdminUsername(String usernameInput, Map adminsMap){
        for (Object key: adminsMap.keySet()) {
            if(key.equals(usernameInput)) {
                return (String) adminsMap.get(key);
            }
        }
        return null;
    }

    public Admin adminPasswordCorrect(String passwordInput, String password, String usernameInput, Interaction interaction){
        if(passwordInput.equals(password)){
            System.out.println("successfully logged in");
            Admin admin = new Admin(usernameInput, password);
            interaction.setLoggedIn(true);
            return admin;
        }
        System.out.println("Incorrect Password");
        return null;
    }



    public Map<String, String> getUsersFromFile() throws IOException {
        InputStream is = new FileInputStream("src/main/resources/users.json");
        Map<String, String> usersMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] values = line.split(", ");
                String username = values[0];
                String password = values[1];
                usersMap.put(username, password);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersMap;
    }

    public String grabUserUsername(String usernameInput, Map usersMap){
        for (Object key: usersMap.keySet()) {
            if(key.equals(usernameInput)) {
                return (String) usersMap.get(key);
            }
        }
        return null;
    }

    public User userPasswordCorrect(String passwordInput, String password, String usernameInput, Interaction interaction){
        if(passwordInput.equals(password)){
            System.out.println("successfully logged in");
            User user = new User(usernameInput, password);
            interaction.setLoggedIn(true);
            return user;
        }
        System.out.println("Incorrect Password");
        return null;
    }



}
