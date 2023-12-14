package org.example;
import java.util.ArrayList;
import java.util.Map;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String address;
    private int regNr;
    private int accountNr;

    private final TextUI ui = new TextUI();

    public User(int id, String username, String password, String email, String address, int regNr, int accountNr) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.regNr = regNr;
        this.accountNr = accountNr;
    }

    public User( String username, String email, String address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getRegNr() {
        return regNr;
    }

    public int getAccountNr() {
        return accountNr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegNr(int regNr) {
        this.regNr = regNr;
    }

    public void setAccountNr(int accountNr) {
        this.accountNr = accountNr;
    }
}