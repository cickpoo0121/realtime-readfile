package com.fotoclub;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        System.out.println("Program starting...");

        BufferedReader bufferedReader = null;
        String currentLine = null;
        ObjectMapper objectMapper = new ObjectMapper();
        // file path can be absolute path
        String path = "F:/Freelance/fotoclubProject/POC/realtime-read-file/src/main/resources/test.json";

        try {
            // open read file
            bufferedReader = new BufferedReader(new FileReader(path));
            while (true) {
                if ((currentLine = bufferedReader.readLine()) != null) {

                    // process a line below here
                    System.out.println(currentLine);

                    Map mapJson = objectMapper.readValue(currentLine, HashMap.class);
                    System.out.println(mapJson);

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