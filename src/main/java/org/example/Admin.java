package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Map;

public class Admin extends Person {

    private boolean isAdmin = true;

    public Admin(String username, String password, int accountID, boolean isAdmin) {
        super(username, password, accountID);
        this.isAdmin = isAdmin;
    }

    public void reportOfBooksOnLoan(){

    }

    public int timesLoanedOut(){
        return 0;
    }

    public void getListOfUsers() throws IOException {

        InputStream is = new FileInputStream("src/main/resources/users.json");
        Reader r = new InputStreamReader(is, "UTF-8");
        Gson gson = new GsonBuilder().create();
        JsonStreamParser p = new JsonStreamParser(r);
        System.out.println("Users:");

        while(p.hasNext()){
            JsonElement e = p.next();
            if(e.isJsonObject()){
                Map<String, String> m = gson.fromJson(e, Map.class);
                for (Map.Entry<String, String> entry: m.entrySet()) {
                    System.out.println(entry.getKey());
                }
            }
        }

    }

}
