package org.example;

import java.util.ArrayList;

import static java.lang.System.exit;

public class Homepage {
    private final TextUI ui = new TextUI();
    //private final DBConnector db = new DBConnector();
    private ArrayList<String> homeMenu = new ArrayList<>();
    private ClothingSelection cs = new ClothingSelection();
    private User currentUser;

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

        if (isLoggedIn()) {
            switch (response.toLowerCase()) {
                case "1":
                case "men":
                case "men clothing":
                    //cs.chooseMenSelection();
                    break;
                case "2":
                case "woman":
                case "woman clothing":
                    //cs.chooseWomenSelection();
                    break;
                case "3":
                case "kids":
                case "kids clothing":
                    //cs.chooseKidsSelection();
                    break;
                case "4":
                case "recycled":
                case "recycled clothing":
                    //cs.chooseRecycledSelection();
                    break;
                case "5":
                case "login":
                    //login();
                    break;
                case "6":
                case "create account":
                    //createAccount();
                    break;
                default:
                    ui.displayMsg("Seems like you made a typo, try again");
                    backToHomepage();
                    break;
            }
        } else {
            switch (response.toLowerCase()) {
                case "1":
                case "men":
                case "men clothing":
                    //cs.chooseMenSelection();
                    System.out.println("men");
                    break;
                case "2":
                case "woman":
                case "woman clothing":
                    //cs.chooseWomenSelection();
                    System.out.println("women");
                    break;
                case "3":
                case "kids":
                case "kids clothing":
                    //cs.chooseKidsSelection();
                    System.out.println("kids");
                    break;
                case "4":
                case "recycled":
                case "recycled clothing":
                    //cs.chooseRecycledSelection();
                    System.out.println("recycled");
                    break;
                case "5":
                case "logout":
                    logout();
                    break;
                default:
                    ui.displayMsg("Seems like you made a typo, try again");
                    backToHomepage();
                    break;
            }
        }
    }

    public void backToHomepage() {
        homepageMenuDialog();
    }

    public void login() {
        String inputUsername = ui.getInput("Enter your username:");
        String inputPassword = ui.getInput("Enter your password:");

        for (User user : db.userList) {
            if (user.getUsername().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
                ui.displayMsg("");
                currentUser = user;
                homeMenu.remove(5);
                homeMenu.set(4, "Logout");
                System.out.println("Welcome " + currentUser.getUsername());
                homepageMenuDialog();
                return;
            }
        }
        ui.displayMsg("");
        System.out.println("Invalid username or password. Please try again.");
        login();
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

    public void logout(){
    }

    public boolean isLoggedIn() {
        if (currentUser != null) {
            return true;
        } else {
            return false;
        }
    }
}

