package org.example;
import java.util.ArrayList;
import java.util.Map;

public class User {
    private String username;
    private String password;
    private final TextUI ui = new TextUI();


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}