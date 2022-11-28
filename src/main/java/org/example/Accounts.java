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

        System.out.println(user);
        return user;
    }

    public Admin registerAdmin(Interaction interaction, int selection, Library library, File adminsFile) throws IOException {
        Admin admin = new Admin(interaction.createUsername(selection), interaction.createPassword(selection));
        library.getAdmins().put(admin.getUsername(), admin.getPassword());

        FileWriter adminsFw = new FileWriter(adminsFile.getAbsoluteFile(), true);
        BufferedWriter adminsBw = new BufferedWriter(adminsFw);
        JSONObject jsonAdmins = new JSONObject(library.getAdmins());

        adminsBw.write(String.valueOf(jsonAdmins));
        adminsBw.close();
        adminsFw.close();
        return admin;
    }

    public Admin[] getAdminsFromFile(Scanner scanner) throws IOException {
        InputStream is = new FileInputStream("src/main/resources/admins.json");
        Reader r = new InputStreamReader(is, "UTF-8");
        Gson gson = new GsonBuilder().create();
        JsonStreamParser p = new JsonStreamParser(r);
        List<Map> allAdmins = new ArrayList<>();

        //String myJson = gson.
        return gson.fromJson(r, Admin[].class);

//        do{
//            JsonElement e = p.next();
//            if(e.isJsonObject()){
//                Map<String,String> adminsMap = gson.fromJson(e, Map.class);
//                allAdmins.add(adminsMap);
//            }
//            System.out.println(allAdmins);
//            return allAdmins;
//        } while(p.hasNext());
    }


    public String grabAdminUsername(String usernameInput, Admin[] allAdmins){
        for (Admin admin: allAdmins) {
//            for (Object key: admin.keySet()) {
//                if(key.equals(usernameInput)) {
//                    System.out.println(allAdmins.get(allAdmins.indexOf(key)+1).get(key).toString());
//                    return allAdmins.get(allAdmins.indexOf(key)+1).get(key).toString();
//                }
//            }
        }
        return null;
    }

    public boolean adminPasswordCorrect(String passwordInput, String password, Admin admin){
        if(passwordInput.equals(password)){
            return true;
        }
        return false;
    }



    public Map<String, String> getUsersFromFile() throws IOException {
        InputStream is = new FileInputStream("src/main/resources/users.json");
        Map<String, String> usersMap = new HashMap<>();
//        for(Map.Entry<String, String> entry : usersMap.entrySet()){
//            System.out.println( entry.getKey() + " => " + entry.getValue() );
//        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] values = line.split(", ");
                String username = values[0];
                String password = values[1];
                usersMap.put(username, password);
                System.out.println(usersMap);
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

    public User userPasswordCorrect(String passwordInput, String password, String usernameInput){
        if(passwordInput.equals(password)){
            System.out.println("successfully logged in");
            User user = new User(usernameInput, password);
            user.setUsername(usernameInput);
            user.setPassword(password);
            return user;
        }
        System.out.println("Incorrect Password");
        return null;
    }



}
