package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Accounts {


    public List<Map> getAdminsFromFile(Scanner scanner) throws IOException {
        InputStream is = new FileInputStream("src/main/resources/admins.json");
        Reader r = new InputStreamReader(is, "UTF-8");
        Gson gson = new GsonBuilder().create();
        JsonStreamParser p = new JsonStreamParser(r);
        List<Map> allAdmins = new ArrayList<>();


        do{
            JsonElement e = p.next();
            if(e.isJsonObject()){
                Map<String,String> adminsMap = gson.fromJson(e, Map.class);
                allAdmins.add(adminsMap);
            }
            System.out.println(allAdmins);
            return allAdmins;
        } while(p.hasNext());
    }


    public String grabAdminUsername(String usernameInput, List<Map> allAdmins){
        for (Map admin: allAdmins) {
            for (Object key: admin.keySet()) {
                if(key.equals(usernameInput)) {
                    System.out.println(allAdmins.get(allAdmins.indexOf(key)+1).get(key).toString());
                    return allAdmins.get(allAdmins.indexOf(key)+1).get(key).toString();
                }
            }
        }
        return null;
    }

    public boolean adminPasswordCorrect(String passwordInput, String password){
        if(passwordInput.equals(password)){
            return true;
        }
        return false;
    }



    public Map<String, String> getUsersFromFile(Scanner scanner) throws IOException {
        InputStream is = new FileInputStream("src/main/resources/users.json");
        Reader r = new InputStreamReader(is, "UTF-8");
        Gson gson = new GsonBuilder().create();
        JsonStreamParser p = new JsonStreamParser(r);

        while(p.hasNext()){
            JsonElement e = p.next();
            Map usersMap = null;
            if(e.isJsonObject()){
                usersMap = gson.fromJson(e, Map.class);
            }
            System.out.println(usersMap);
            return usersMap;
        }
        return null;
    }

    public String grabUserUsername(String usernameInput, Map usersMap){
        for (Object key: usersMap.keySet()) {
            if(key.equals(usernameInput)) {
                return (String) usersMap.get(key);
            }
        }
        return null;
    }

    public boolean userPasswordCorrect(String passwordInput, String password){
        if(passwordInput.equals(password)){
            System.out.println("successfully logged in");
            return true;
        }
        System.out.println("Incorrect Password");
        return false;
    }



}
