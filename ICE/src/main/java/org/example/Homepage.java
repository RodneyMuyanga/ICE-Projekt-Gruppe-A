package org.example;

import java.util.ArrayList;

public class Homepage {
    private final TextUI ui = new TextUI();
    private final ShoppingCart cart = new ShoppingCart();
    private final DBConnector db = new DBConnector();
    private ArrayList<String> homeMenu = new ArrayList<>();
    private ArrayList<String> selectClothesOrNotMenu = new ArrayList<>();
    private ClothingSelection cs = new ClothingSelection();
    private ManageRecycled mr = new ManageRecycled();
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
        homeMenu.add("[1] Men's clothing");
        homeMenu.add("[2] Women's clothing");
        homeMenu.add("[3] Kids clothing");
        homeMenu.add("[4] Recycled Clothing");
        homeMenu.add("[5] Login");
        homeMenu.add("[6] Create Account");
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
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "2":
                case "woman":
                case "woman clothing":
                    cs.chooseWomenSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "3":
                case "kids":
                case "kids clothing":
                    cs.chooseKidsSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "4":
                case "recycled":
                case "recycled clothing":
                    cs.chooseRecycledSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "5":
                case "sell":
                    mr.sellingDialog();
                case "6":
                case "logout":
                    //logout();
                default:
                    ui.displayMsg("Seems like you made a typo, try again\n");
                    homepageMenuDialog();
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
                    cs.chooseWomenSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "3":
                case "kids":
                case "kids clothing":
                    cs.chooseKidsSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "4":
                case "recycled":
                case "recycled clothing":
                    cs.chooseRecycledSelection();
                    selectClothesOrNotDialogQuestionMark();
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
                    homepageMenuDialog();
                    break;
            }
        }
    }

    private void selectClothesOrNotDialogQuestionMark() {
        selectClothesOrNotMenu();
        ui.displayMsg("Choose an option");
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
        String userInput = ui.getInput("Type the ID-number of the clothes you want to add to your cart\nPress X to return to the previous menu");

        if (userInput.equalsIgnoreCase("X")){
            homepageMenuDialog();
            return;
        }

        int selectID;
        try {
            selectID = Integer.parseInt(userInput);
        } catch (NumberFormatException e){
            ui.displayMsg("Invalid input. Please enter a valid ID or 'X' to return to the previous menu");
            selectClothesDialog(clothing);
            return;
        }

        boolean found = false;

        for (Clothing c : clothing) {
            if (selectID == c.getID()) {
                if (c.stock > 0) {
                    int amount = ui.getNumericInput("How many would you like to add to cart? There are currently " + c.getStock() + " amount in stock");

                    if (amount <= c.stock) {
                        for (int i = 0; i < amount; i++) {
                            cart.itemsInCart.add(c);
                        }
                        c.stock -= amount;
                        ui.displayMsg(amount + " amount of " + c.getBrand() + " " + c.getModel() + " has been added to cart\n");
                        found = true;

                        String choice = ui.getInput("[1] Continue shopping\n[2] Continue to payment\n");
                        if (choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("shop")) {
                            ui.displayMsg("Returning back to the menu...\n");
                            homepageMenuDialog();
                        } else if (choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("payment")) {
                            cart.CartDialog();
                        } else {
                            ui.displayMsg("Seems like you made a typo, try again");
                            selectClothesDialog(clothing);
                        }
                    } else {
                        ui.displayMsg("Please try again");
                        selectClothesDialog(clothing);
                    }
                } else if (selectID == c.getID() && c.stock <= 0) {
                    ui.displayMsg("This product is currently out of stock. Please try again");
                    selectClothesDialog(clothing);
                }
            }
        }
        if (String.valueOf(selectID).equalsIgnoreCase("X")) {
            cart.paymentDialog();
        }
        if (!found) {
            ui.displayMsg("Invalid ID. Please try again");
            selectClothesDialog(clothing);
        }
    }

    public void login() {
        String inputUsername = ui.getInput("Enter your username:");
        String inputPassword = ui.getInput("Enter your password:");


        for (User user : db.mainUser) {
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
        String inputEmail = ui.getInput("Enter a e-mail");
        String inputAddress = ui.getInput("Enter your address");
        int inputRegNr = Integer.parseInt(ui.getInput("Enter your Registration number"));
        int inputAccountNr = Integer.parseInt(ui.getInput("Enter your Account number"));

        ui.displayMsg("");
        db.saveUserData(newUsername, newPassword,inputEmail, inputAddress,inputRegNr,inputAccountNr);
        ui.displayMsg("New user created successfully");
        db.readUserData();
        login();
    }
    public void logout() {
        currentUser = null;
        homepageMenuDialog();
    }
    public boolean isLoggedIn() {
        if (currentUser != null) {
            homeMenu.set(4, "[5] Sell Clothes");
            homeMenu.set(5, "[6] Logout");
            return true;
        } else {
            homeMenu.set(4, "[5] Login");
            homeMenu.set(5, "[6] Create Account");
            return false;
        }
    }
}


