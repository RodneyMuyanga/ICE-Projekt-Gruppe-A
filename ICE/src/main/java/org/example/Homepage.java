package org.example;

import java.util.ArrayList;

public class Homepage {
    private final TextUI ui = new TextUI();
    //private final DBConnector db = new DBConnector();
    private ArrayList<String> homeMenu = new ArrayList<>();
    private ClothingSelection cs = new ClothingSelection();

    Homepage() {
    }

    public void setup() {
        homepageMenu();
        homepageMenuDialog();
        //chooseMenMenu();
    }

    public void homepageMenu() {
        homeMenu.add("[1] Men");
        homeMenu.add("[2] Women");
        homeMenu.add("[3] Kids");
        homeMenu.add("[4] Recycled Clothing");
        homeMenu.add("[5] Login");
        homeMenu.add("[6] Create account");
    }

    public void homepageMenuDialog() {
        ui.displayMsg("Welcome to Renewed Couture GangGang Corner\n Choose a category");
        for (int i = 0; i < homeMenu.size(); i++) {
            ui.displayMsg(homeMenu.get(i));
        }
        String response = ui.getInput("");

        switch (response.toLowerCase()) {
            case "1":
            case "men":
            case "men clothing":
                cs.chooseMenSelection();
                break;
            case "2":
            case "woman":
            case "woman clothing":
                cs.chooseWomenSelection();
                break;
            case "3":
            case "kids":
            case "kids clothing":
                cs.chooseKidsSelection();
                break;
            case "4":
            case "recycled":
            case "recycled clothing":
                cs.chooseRecycledSelection();
                break;
            case "5":
            case "login":
                login();
                break;
            case "6":
            case "create account":
                createAccount();
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again");
                backToHomepage();
                break;
        }
    }
    public void backToHomepage(){
        homepageMenuDialog();
    }

    public void login(){
        String inputUsername = ui.getInput("Enter your username:");
        String inputPassword = ui.getInput("Enter your password:");

        for (User user : db.userList) {
            if (user.getUsername().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
                ui.displayMsg("");
                userName2 = inputUserName;
                System.out.println("Welcome " + userName2);
                homepageMenuDialog();
                return;
            }
        }
        ui.displayMsg("");
        System.out.println("Invalid username or password. Please try again.");
        loginAccount();
    }


    public void createAccount() {
        String newUsername = ui.getInput("Enter a new username:");
        String newPassword = ui.getInput("Enter a new password:");

        ui.displayMsg("");
        db.saveUserData(newUsername, newPassword);
        ui.displayMsg("New user created successfully");
        db.readUserData();
        login();
    }
}

