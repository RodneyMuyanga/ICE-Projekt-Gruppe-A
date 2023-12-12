package org.example;
import java.util.ArrayList;
import java.util.Map;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String adress;
    private int regNr;
    private int accountNr;

    private final TextUI ui = new TextUI();


    public User(String username, String password, String email, String adress, int regNr, int accountNr) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email) {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}