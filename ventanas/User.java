/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loginapp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class User {
    private static Map<String, String> users = new HashMap<>();
    private static final String FILE_PATH = "users.csv";

    static {
        loadUsersFromFile();
    }

    public static boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Usuario ya existe
        }
        users.put(username, password);
        saveUserToFile(username, password);
        return true;
    }

    public static boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    private static void saveUserToFile(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(username + "," + password);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    users.put(data[0], data[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de usuarios, se creará uno nuevo.");
        }
    }
}
