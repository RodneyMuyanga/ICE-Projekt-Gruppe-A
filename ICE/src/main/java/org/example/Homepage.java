package org.example;

import java.util.ArrayList;

public class Homepage {
    private final TextUI ui = new TextUI();
    private final ShoppingCart cart = new ShoppingCart();
    private final DBConnector db = new DBConnector();
    private ArrayList<String> homeMenu = new ArrayList<>();
    private ArrayList<String> selectClothesOrNotMenu = new ArrayList<>();
    private ManageRecycled mr = new ManageRecycled();
    private User currentUser;
    private ArrayList<String> chooseClothingMenu = new ArrayList<>();
    private ArrayList<String> chooseRecycledClothingMenu = new ArrayList<>();
    protected ArrayList<Clothing> chosenClothes;
    private String userName2 = "";

    public void setup() {
        db.readUserData();
        db.readAllData();
        ui.displayMsg("Welcome to Renewed Couture GangGang Corner\n");
        homepageMenu();
        homepageMenuDialog();
        //ManageRecycled manageRecycled = new ManageRecycled(90, "type", "brand", "gender", "color");
        //manageRecycled.sellingDialog();
        //chooseMenMenu();
    }

    public void login() {
        String inputUserName = ui.getInput("Enter your username:");
        String inputPassword = ui.getInput("Enter your password:");

        for (User user : db.getMainUser()) {
            if (user.getUsername().equals(inputUserName) && user.getPassword().equals(inputPassword)) {
                ui.displayMsg("");
                userName2 = inputUserName;
                currentUser = user;
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
        homeMenu.set(4, "[5] Login");
        homeMenu.set(5, "[6] Create Account");
        homepageMenuDialog();
    }
    public boolean isLoggedIn() {
        if (currentUser != null) {
            homeMenu.set(4, "[5] Sell Clothes");
            homeMenu.set(5, "[6] Logout");
            return true;
        } else {
            return false;
        }
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
        //homepageMenu();
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
                    chooseMenSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "2":
                case "woman":
                case "woman clothing":
                    chooseWomenSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "3":
                case "kids":
                case "kids clothing":
                    chooseKidsSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "4":
                case "recycled":
                case "recycled clothing":
                    chooseRecycledSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "5":
                case "sell":
                    mr.sellingDialog();
                    break;
                case "6":
                case "logout":
                    //logout();
                    break;
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
                    chooseMenSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "2":
                case "woman":
                case "woman clothing":
                    chooseWomenSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "3":
                case "kids":
                case "kids clothing":
                    chooseKidsSelection();
                    selectClothesOrNotDialogQuestionMark();
                    break;
                case "4":
                case "recycled":
                case "recycled clothing":
                    chooseRecycledSelection();
                    selectClothesOrNotDialogQuestionMark();
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
                selectClothesDialog(getChosenClothes());
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

    public void chooseClothingMenu() {
        if (chooseClothingMenu.size() != 8) {
            chooseClothingMenu.add("[1] All clothes");
            chooseClothingMenu.add("[2] Jackets");
            chooseClothingMenu.add("[3] Hoodies");
            chooseClothingMenu.add("[4] T-shirts");
            chooseClothingMenu.add("[5] Pants");
            chooseClothingMenu.add("[6] Sneakers");
            chooseClothingMenu.add("[7] Boots");
            chooseClothingMenu.add("[8] Back");
        }
    }
    public void chooseRecycledClothingMenu(){
        if(chooseRecycledClothingMenu.size() !=2){
            chooseRecycledClothingMenu.add("[1] All clothes");
            chooseRecycledClothingMenu.add("[2] Back");
        }
    }
    public ArrayList<Clothing> chooseMenSelection() {
        chooseClothingMenu();
        ui.displayMsg("Men's Clothing Menu:\n");
        for (int i = 0; i < chooseClothingMenu.size(); i++) {
            System.out.println(chooseClothingMenu.get(i));
        }
        String response = ui.getInput("");
        switch (response.toLowerCase()) {
            case "1":
            case "all clothes":
                ui.displayMsg("Displaying all clothes\n");
                db.readAllData();
                for (Clothing clothing : db.getAllMenClothes()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getAllMenClothes();
            //break;
            case "2":
            case "jackets":
                ui.displayMsg("Displaying all jackets\n");
                db.readMenJackets();
                for (Clothing clothing : db.getJacketsForMen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getJacketsForMen();
            //break;
            case "3":
            case "hoodies":
                ui.displayMsg("Displaying all hoodies\n");
                db.readMenHoodies();
                for (Clothing clothing : db.getHoodiesForMen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getHoodiesForMen();
            //break;
            case "4":
            case "t-shirts":
                ui.displayMsg("Displaying all T-shirts\n");
                db.readMenTshirts();
                for (Clothing clothing : db.getTshirtsForMen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getTshirtsForMen();
            //break;
            case "5":
            case "pants":
                ui.displayMsg("Displaying all pants\n");
                db.readMenPants();
                for (Clothing clothing : db.getPantsForMen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getPantsForMen();
            //break;
            case "6":
            case "sneakers":
                ui.displayMsg("Displaying all sneakers\n");
                db.readMenSneakers();
                for (Clothing clothing : db.getSneakersForMen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getSneakersForMen();
            case "7":
            case "boots":
                ui.displayMsg("Displaying all boots\n");
                db.readMenBoots();
                for (Clothing clothing : db.getBootsForMen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getBootsForMen();
            case "8":
            case "back":
                ui.displayMsg("Returning back to the home-menu...");
                homepageMenuDialog();
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                ui.displayMsg("");
                return chooseMenSelection();
        }
        return null;
    }

    public ArrayList<Clothing> chooseWomenSelection() {
        chooseClothingMenu();
        ui.displayMsg("Women's Clothing Menu:");
        for (int i = 0; i < chooseClothingMenu.size(); i++) {
            System.out.println(chooseClothingMenu.get(i));
        }
        String response = ui.getInput("");

        switch (response.toLowerCase()) {
            case "1":
            case "all clothes":
                ui.displayMsg("Displaying all clothes\n");
                db.readAllData();
                for (Clothing clothing : db.getAllWomenClothes()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getAllWomenClothes();
            case "2":
            case "jackets":
                ui.displayMsg("Displaying all jackets\n");
                db.readWomenJackets();
                for (Clothing clothing : db.getJacketsForWomen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getJacketsForWomen();
            case "3":
            case "hoodies":
                ui.displayMsg("Displaying all hoodies\n");
                db.readWomenHoodies();
                for (Clothing clothing : db.getHoodiesForWomen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getHoodiesForWomen();
            case "4":
            case "t-shirts":
                ui.displayMsg("Displaying all t-shirts\n");
                db.readWomenTshirts();
                for (Clothing clothing : db.getTshirtsForWomen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getTshirtsForWomen();
            case "5":
            case "pants":
                ui.displayMsg("Displaying all pants\n");
                db.readWomenPants();
                for (Clothing clothing : db.getPantsForWomen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getPantsForWomen();
            case "6":
            case "sneakers":
                ui.displayMsg("Displaying all sneakers\n");
                db.readWomenSneakers();
                for (Clothing clothing : db.getSneakersForWomen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getSneakersForWomen();
            case "7":
            case "boots":
                ui.displayMsg("Displaying all boots\n");
                db.readWomenBoots();
                for (Clothing clothing : db.getBootsForWomen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getBootsForWomen();
            case "8":
            case "back":
                ui.displayMsg("Returning back to the home-menu...");
                homepageMenuDialog();
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                ui.displayMsg("");
                return chooseWomenSelection();
        }
        return null;
    }

    public ArrayList<Clothing> chooseKidsSelection() {
        chooseClothingMenu();
        ui.displayMsg("Kids Clothing Menu:\n");
        for (int i = 0; i < chooseClothingMenu.size(); i++) {
            ui.displayMsg((i + 1) + ". " + chooseClothingMenu.get(i));
        }
        String response = ui.getInput("");

        switch (response.toLowerCase()) {
            case "1":
            case "all clothes":
                ui.displayMsg("Displaying all clothes\n");
                db.readAllData();
                for (Clothing clothing : db.getAllKidsClothes()) {
                    System.out.println((clothing));
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getAllKidsClothes();
            case "2":
            case "jackets":
                ui.displayMsg("Displaying all jackets\n");
                db.readJacketsForKids();
                for (Clothing clothing : db.getJacketsForKids()) {
                    System.out.println((clothing));
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getJacketsForKids();
            case "3":
            case "hoodies":
                ui.displayMsg("Displaying all hoodies\n");
                db.readHoodiesForKids();
                for (Clothing clothing : db.getHoodiesForKids()) {
                    System.out.println((clothing));
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getHoodiesForKids();
            case "4":
            case "t-shirts":
                ui.displayMsg("Displaying all t-shirts\n");
                db.readTshirtForKids();
                for (Clothing clothing : db.getTshirtsForKids()) {
                    System.out.println((clothing));
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getTshirtsForKids();
            case "5":
            case "pants":
                ui.displayMsg("Displaying all pants\n");
                db.readPantsForKids();
                for (Clothing clothing : db.getPantsForKids()) {
                    System.out.println((clothing));
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getPantsForKids();
            case "6":
            case "sneakers":
                ui.displayMsg("Displaying all sneakers\n");
                db.readSneakersForKids();
                for (Clothing clothing : db.getSneakersForKids()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getSneakersForKids();
            case "7":
            case "boots":
                ui.displayMsg("Displaying all boots\n");
                db.readBootsForKids();
                for (Clothing clothing : db.getBootsForKids()) {
                    System.out.println((clothing));
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getBootsForKids();
            case "8":
            case "back":
                ui.displayMsg("Returning back to the home-menu.");
                homepageMenuDialog();
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                ui.displayMsg("");
                return chooseKidsSelection();
        }
        return null;
    }


    public ArrayList<Clothing> chooseRecycledSelection() {
        chooseRecycledClothingMenu();
        ui.displayMsg("Recycled Clothing Menu:\n");
        for (int i = 0; i < chooseRecycledClothingMenu.size(); i++) {
            ui.displayMsg((i + 1) + ". " + chooseRecycledClothingMenu.get(i));
        }
        String response = ui.getInput("");

        switch (response.toLowerCase()) {
            case "1":
            case "all clothes":
                ui.displayMsg("Displaying all recycled clothes\n");
                db.readRecycledClothes();
                for (Clothing clothing : db.getAllRecycledClothes()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getAllRecycledClothes();
            case "2":
            case "back":
                ui.displayMsg("Returning back to the home-menu...");
                homepageMenuDialog();
                break;
            default:
                ui.displayMsg("Try again");
                chooseRecycledSelection();
        }
        return null;
    }
    public ArrayList<Clothing> getChosenClothes() {
        return chosenClothes;
    }
}


