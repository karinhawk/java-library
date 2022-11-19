package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.CDL;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileParser {

    public static void main(String[] args) {

//
//        InputStream inputStream = FileParser.class.getClassLoader().getResourceAsStream("books.csv");
//        System.out.println(inputStream);
//        assert inputStream != null;
//        String csvAsString = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
//        String json = CDL.toJSONArray(csvAsString).toString();
//        try {
//            Files.write(Path.of("src/main/resources/books.json"), json.getBytes(StandardCharsets.UTF_8));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
