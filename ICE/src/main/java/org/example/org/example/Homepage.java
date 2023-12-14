package org.example;

import java.util.ArrayList;

public class Homepage {
    private final TextUI ui = new TextUI();
    private final ShoppingCart cart = new ShoppingCart();
    private final DBConnector db = new DBConnector();
    private ArrayList<String> homeMenu = new ArrayList<>();
    private ArrayList<String> selectClothesOrNotMenu = new ArrayList<>();
    private ClothingSelection cs = new ClothingSelection();
    private User currentUser;

    public void setup() {
        db.readAllData();
        ui.displayMsg("Welcome to Renewed Couture GangGang Corner\n");
        homepageMenu();
        homepageMenuDialog();
        //ManageRecycled manageRecycled = new ManageRecycled(90, "type", "brand", "gender", "color");
        //manageRecycled.sellingDialog();
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

    public void selectClothesOrNotMenu() { // extra filter brands
        if (selectClothesOrNotMenu.size() != 2) {
            selectClothesOrNotMenu.add("[1] Select clothes");
            selectClothesOrNotMenu.add("[2] Back");
        }
    }


    public void homepageMenuDialog() {
        ui.displayMsg("Choose a category");
        for (int i = 0; i < homeMenu.size(); i++) {
            ui.displayMsg(homeMenu.get(i));
        }
        String response = ui.getInput("");

        if (isLoggedIn()) {
            switch (response.toLowerCase()) {
                case "1":
                case "men":
                case "men clothing":
                    cs.chooseMenSelection();
                    //selectClothesOrNotDialogQuestionMark();
                    break;
                case "2":
                case "woman":
                case "woman clothing":
                    //cs.chooseWomenSelection();
                    //selectClothesOrNotDialogQuestionMark();
                    break;
                case "3":
                case "kids":
                case "kids clothing":
                    //cs.chooseKidsSelection();
                    //selectClothesOrNotDialogQuestionMark();
                    break;
                case "4":
                case "recycled":
                case "recycled clothing":
                    //cs.chooseRecycledSelection();
                    //selectClothesOrNotDialogQuestionMark();
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
                    ui.displayMsg("Seems like you made a typo, try again\n");
                    backToHomepage();
                    break;
            }
        } else {
            switch (response.toLowerCase()) {
                case "1":
                case "men":
                case "men clothing":
                    cs.chooseMenSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "2":
                case "woman":
                case "woman clothing":
                    //cs.chooseWomenSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "3":
                case "kids":
                case "kids clothing":
                    //cs.chooseKidsSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "4":
                case "recycled":
                case "recycled clothing":
                    //cs.chooseRecycledSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "5":
                case "logout":
                    logout();
                    break;
                default:
                    ui.displayMsg("Seems like you made a typo, try again\n");
                    backToHomepage();
                    break;
            }
        }
    }

    private void selectClothesOrNotDialogQuestionMark() {
        selectClothesOrNotMenu();
        ui.displayMsg("Choose a category");
        for (int i = 0; i < selectClothesOrNotMenu.size(); i++) {
            ui.displayMsg(selectClothesOrNotMenu.get(i));
        }
        String response = ui.getInput("");

        switch (response.toLowerCase()) {
            case "1":
            case "select":
            case "select clothes":
                selectClothesDialog(cs.getChosenClothes());
                break;
            case "2":
            case "back":
                homepageMenuDialog();
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                selectClothesOrNotDialogQuestionMark();
                break;
        }
    }

    private void selectClothesDialog(ArrayList<Clothing> clothing) {
        String selectID = ui.getInput("Type the ID-number of the clothes you want to add to your basket. Finish with 'Q'");

        boolean found = false;

        for (Clothing c : clothing) {

            if (Integer.parseInt(selectID) == c.getID()) {
                cart.getItemsInCart().add(c);
                System.out.println(c + " has been added to cart");
                found = true;
                break;
            } else if (selectID.equalsIgnoreCase("Q")) {
                //move on to payment
                System.out.println("moving on to payment...");
            }
        }
        if (!found) {
            ui.displayMsg("Invalid ID. Please try again");
            selectClothesDialog(clothing);
        }
    }

    public void backToHomepage() {
        homepageMenuDialog();
    }

/*    public void login() {
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
    }*/


    /*public void createAccount() {
        String newUsername = ui.getInput("Enter a new username:");
        String newPassword = ui.getInput("Enter a new password:");

        ui.displayMsg("");
        db.saveUserData(newUsername, newPassword);
        ui.displayMsg("New user created successfully");
        db.readUserData();
        login();
    }*/

    public void logout() {
    }

    public boolean isLoggedIn() {
        if (currentUser != null) {
            return true;
        } else {
            return false;
        }
    }
}

