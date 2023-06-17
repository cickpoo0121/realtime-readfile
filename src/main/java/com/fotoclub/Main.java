package com.fotoclub;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        System.out.println("Program starting...");

        BufferedReader bufferedReader = null;
        String currentLine = null;
        ObjectMapper objectMapper = new ObjectMapper();
        // file path can be absolute path
        String path = "../main/resources/test.txt";

        try {
            // sample load json string to map
            String str = "{\r\n  \"userId\": 1,\r\n  \"id\": 1,\r\n  \"title\": \"delectus aut autem\",\r\n  \"completed\": false\r\n}";
            Map myMap = objectMapper.readValue(str, Map.class);
            System.out.println(myMap);

            // open read file
            bufferedReader = new BufferedReader(new FileReader(path));
            while (true) {
                if ((currentLine = bufferedReader.readLine()) != null) {

                    // process a line below here

                    System.out.println(currentLine);

                    continue;
                }

                // delay 1s for pending read a new line
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            // close read file
            bufferedReader.close();
        } catch (Exception err) {
            System.out.println("Error:" + err);
        }
    }
}