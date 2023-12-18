package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class Homepage {
    private final TextUI ui = new TextUI();
    private final ShoppingCart cart = new ShoppingCart();
    private final DBConnector db = new DBConnector();
    private ArrayList<String> homeMenu = new ArrayList<>();
    private ArrayList<String> selectClothesOrNotMenu = new ArrayList<>();
    //private ManageRecycled mr = new ManageRecycled();
    User currentUser = new User();
    private ArrayList<String> chooseClothingMenu = new ArrayList<>();
    private ArrayList<String> chooseRecycledClothingMenu = new ArrayList<>();
    protected ArrayList<Clothing> chosenClothes;
    protected ArrayList<String> homeMenu_loggedIn = new ArrayList<>();

    public void setup() {
        db.readUserData();
        db.readAllData();
        ui.displayMsg("Welcome to Renewed Couture GangGang Corner\n");
        homepageMenu();
        homepageMenu_loggedIn();
        chooseClothingMenu();
        selectClothesOrNotMenu();
        chooseRecycledClothingMenu();
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
                currentUser = user;
                System.out.println("Welcome " + currentUser.getUsername());
                homepageMenuDialog_LoggedIn();
                return;
            }
        }
        ui.displayMsg("");
        System.out.println("Invalid username or password. Please try again.");
        String userInput = ui.getInput("\nPress X to return to the previous menu");
        if (userInput.equalsIgnoreCase("X")) {
            homepageMenuDialog();
        } else {
            login();
        }
    }

    public void createAccount() {
        String newUsername = ui.getInput("Enter a new username:");
        String newPassword = ui.getInput("Enter a new password:");
        String inputEmail = ui.getInput("Enter a e-mail");
        String inputAddress = ui.getInput("Enter your address");
        int inputRegNr = Integer.parseInt(ui.getInput("Enter your Registration number"));
        int inputAccountNr = Integer.parseInt(ui.getInput("Enter your Account number"));

        ui.displayMsg("");
        db.saveUserData(newUsername, newPassword, inputEmail, inputAddress, inputRegNr, inputAccountNr);
        ui.displayMsg("New user created successfully");
        db.readUserData();
        login();
    }

    /*public void logout() {
        currentUser = null;
        homeMenu.set(4, "[5] Login");
        homeMenu.set(5, "[6] Create Account");
        homepageMenuDialog();
    }*/

    public boolean isLoggedIn() {
        if (currentUser != null) {

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
        homeMenu.add("[5] Checkout");
        homeMenu.add("[6] Login");
        homeMenu.add("[7] Create Account");
    }

    public void homepageMenu_loggedIn() {
        homeMenu_loggedIn.add("[1] Men's clothing");
        homeMenu_loggedIn.add("[2] Women's clothing");
        homeMenu_loggedIn.add("[3] Kids clothing");
        homeMenu_loggedIn.add("[4] Recycled Clothing");
        homeMenu_loggedIn.add("[5] Checkout");
        homeMenu_loggedIn.add("[6] Sell");
        homeMenu_loggedIn.add("[7] Logout");
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

        switch (response.toLowerCase()) {
            case "1":
            case "men":
            case "men clothing":
                chooseMenSelection();
                selectClothesOrNotDialogQuestionMark();
                homepageMenuDialog();
                break;
            case "2":
            case "woman":
            case "woman clothing":
                chooseWomenSelection();
                selectClothesOrNotDialogQuestionMark();
                homepageMenuDialog();
                break;
            case "3":
            case "kids":
            case "kids clothing":
                chooseKidsSelection();
                selectClothesOrNotDialogQuestionMark();
                homepageMenuDialog();
                break;
            case "4":
            case "recycled":
            case "recycled clothing":
                chooseRecycledSelection();
                selectClothesOrNotDialogQuestionMark();
                homepageMenuDialog();
                break;
            case "5":
            case "checkout":
                cart.CartDialog();
                break;
            case "6":
            case "login":
                login();
                break;
            case "7":
            case "create account":
                createAccount();
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                homepageMenuDialog();
                break;
        }
    }


    private void homepageMenuDialog_LoggedIn() {
        //homepageMenu();
        ui.displayMsg("Choose a category");
        for (int i = 0; i < homeMenu_loggedIn.size(); i++) {
            ui.displayMsg(homeMenu_loggedIn.get(i));
        }
        String response = ui.getInput("");

        switch (response.toLowerCase()) {
            case "1":
            case "men":
            case "men clothing":
                chooseMenSelection();
                selectClothesOrNotDialogQuestionMark();
                homepageMenuDialog_LoggedIn();
                break;
            case "2":
            case "woman":
            case "woman clothing":
                chooseWomenSelection();
                selectClothesOrNotDialogQuestionMark();
                homepageMenuDialog_LoggedIn();
                break;
            case "3":
            case "kids":
            case "kids clothing":
                chooseKidsSelection();
                selectClothesOrNotDialogQuestionMark();
                homepageMenuDialog_LoggedIn();
                break;
            case "4":
            case "recycled":
            case "recycled clothing":
                chooseRecycledSelection();
                selectClothesOrNotDialogQuestionMark();
                homepageMenuDialog_LoggedIn();
                break;
            case "5":
            case "checkout":
                cart.CartDialog();
                break;
            case "6":
            case "sell":
                sellingDialog();
                break;
            case "7":
            case "logout":
                //logout();
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                homepageMenuDialog_LoggedIn();
                break;
        }
    }


    private void selectClothesOrNotDialogQuestionMark() {
        //selectClothesOrNotMenu();
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

        if (userInput.equalsIgnoreCase("X")) {
            homepageMenuDialog();
            return;
        }

        int selectID;
        try {
            selectID = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
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
                            return;
                        } else {
                            ui.displayMsg("Seems like you made a typo, try again");
                            selectClothesDialog(clothing);
                        }
                    } else {
                        ui.displayMsg("Invalid number. Please try again");
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

    public void chooseRecycledClothingMenu() {
        if (chooseRecycledClothingMenu.size() != 2) {
            chooseRecycledClothingMenu.add("[1] All clothes");
            chooseRecycledClothingMenu.add("[2] Back");
        }
    }

    public ArrayList<Clothing> chooseMenSelection() {
        //chooseClothingMenu();
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
                if (isLoggedIn()) {
                    homepageMenuDialog_LoggedIn();
                } else {
                    homepageMenuDialog();
                }
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                ui.displayMsg("");
                return chooseMenSelection();
        }
        return null;
    }

    public ArrayList<Clothing> chooseWomenSelection() {
        //chooseClothingMenu();
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
                if (isLoggedIn()) {
                    homepageMenuDialog_LoggedIn();
                } else {
                    homepageMenuDialog();
                }
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                ui.displayMsg("");
                return chooseWomenSelection();
        }
        return null;
    }

    public ArrayList<Clothing> chooseKidsSelection() {
        //chooseClothingMenu();
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
                if (isLoggedIn()) {
                    homepageMenuDialog_LoggedIn();
                } else {
                    homepageMenuDialog();
                }
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                ui.displayMsg("");
                return chooseKidsSelection();
        }
        return null;
    }


    public ArrayList<Clothing> chooseRecycledSelection() {
        //chooseRecycledClothingMenu();
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
                if (isLoggedIn()) {
                    homepageMenuDialog_LoggedIn();
                } else {
                    homepageMenuDialog();
                }
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
//
//    TextUI ui = new TextUI();
//    DBConnector db = new DBConnector();
//    Homepage homepage = new Homepage();


    public void sellingDialog() {
        if (isLoggedIn()) {
            ui.displayMsg("");

            ui.displayMsg("Welcome " + currentUser.getUsername() + " to the Recyclingpage, where we sell your old clothing.\nLet's get started.");
        } else {
            ui.displayMsg("Please login or register as a user in order to sell clothes");
            String choice = ui.getInput("[1] Log in \n[2] Register user");
            if (choice.equals("1")) {
                login();
            } else {
                createAccount();
            }

        }

        registerClothing();
    }

    public String askGender() {
        return ui.getInput("Enter gender Men/Women");
    }

    public String askSize() {
        return ui.getInput("Enter the size in XS, S, M, L, XL and XXL");
    }

    public void registerClothing() {
        String inputBrand = ui.getInput("Enter clothing brand");
        inputBrand = inputBrand.substring(0, 1).toUpperCase() + inputBrand.substring(1);

        String inputModel = ui.getInput("Enter model name");
        inputModel = inputModel.substring(0, 1).toUpperCase() + inputModel.substring(1);

        String inputGender;
        do {
            inputGender = askGender();
            inputGender = inputGender.substring(0, 1).toUpperCase() + inputGender.substring(1);
            if (!(inputGender.equalsIgnoreCase("Men") || inputGender.equalsIgnoreCase("Women"))) {
                ui.displayMsg("ENTER MEN OR WOMEN!");
            }
        } while (!(inputGender.equalsIgnoreCase("Men") || inputGender.equalsIgnoreCase("Women")));


        String inputSize;
        do {
            inputSize = askSize();
            inputSize = inputSize.toUpperCase();
            if (!(inputSize.equals("XS") || inputSize.equals("S") || inputSize.equals("M") || inputSize.equals("L") || inputSize.equals("XL") || inputSize.equals("XXL"))) {
                ui.displayMsg("Enter the size in XS, S, M, L, XL and XXL");
            }
        } while (!(inputSize.equals("XS") || inputSize.equals("S") || inputSize.equals("M") || inputSize.equals("L") || inputSize.equals("XL") || inputSize.equals("XXL")));


        String inputColor = ui.getInput("Enter clothing color");
        inputColor = inputColor.substring(0, 1).toUpperCase() + inputColor.substring(1);

        ui.displayMsg("");
        String input = ui.getInput("Are the information correct? : \n" + " Brand: " + inputBrand + "\n Model: " + inputModel + "\n Gender: " + inputGender + "\n Size: " + inputSize + "\n Color: " + inputColor + "\n\nPress 'Y' for yes and 'N' for no.");

        if (input.equalsIgnoreCase("Y")) {
            //db.RecyclingClothes.add( clothing);
            //ui.displayMsg("\n Perfect lets register the clothing in our system");

        } else if (input.equalsIgnoreCase("N")) {
            ui.displayMsg("Try again");
            registerClothing();
        }


        ui.displayMsg("\nThe clothing is now registered");

        //paymentCalculator();

        int sellPrice = paymentCalculator();
        RecycledClothes recycledClothing = new RecycledClothes(inputBrand, inputModel, inputGender, inputSize, inputColor, sellPrice);
        db.saveRecycledClothes(inputBrand, inputModel, inputGender, inputSize, inputColor, sellPrice);

    }

    public int paymentCalculator() {
        int inputOldPrice = ui.getNumericInput("Enter the old price, for the clothing in $. ");

        double returnPrice = 0.35 * inputOldPrice;
        double sellPrice = 0.90 * inputOldPrice;

        ui.displayMsg("\nYou will get: " + returnPrice + "$ for your product");
        String input = ui.getInput("\nWould you like to accept this offer or decline? Pres 'Y' for Yes and 'N' for no ");

        if (input.equalsIgnoreCase("Y")) {
            ui.displayMsg("\nWe will now send a e-mail to " + currentUser.getEmail() + " with next steps.\nThank you for choosing Renewed Couture GangGang Corner ");

        } else if (input.equalsIgnoreCase("N")) {
            {
                ui.displayMsg("Unfortunately we cannot offer a different price for the clothes. Please try again");
                //paymentCalculator();
            }
        }
        return (int) sellPrice;
    }

        protected ArrayList<Clothing> itemsInCart = new ArrayList<>();
        private final ArrayList<String>ShoppingCartMenu = new ArrayList<>();
        private int paymentID;
        private double amount;
        private Homepage homepage;

        public ArrayList<Clothing> getItemsInCart() {
            return itemsInCart;
        }
        private void displayCart(){
            for (Clothing clothing : itemsInCart){
                System.out.println((clothing));
            }
        }

        public void shoppingMenu() {
            if ( ShoppingCartMenu.size() != 3){
                ShoppingCartMenu.add("[1] Checkout");
                ShoppingCartMenu.add("[2] Shop more");
                ShoppingCartMenu.add("[3] Remove items");
            }
            for (String i : ShoppingCartMenu){
                System.out.println(i);
            }
        }

        public void CartDialog(){
            ui.displayMsg("Your cart: ");
            displayCart();
            ui.displayMsg("Total: " + getTotalPrice() + "$");
            ui.displayMsg("");

            String input = "";
            ui.displayMsg("Would you like to continue shopping?");
            ui.displayMsg("");
            shoppingMenu();
            input = ui.getInput("");


            switch (input.toLowerCase()) {
                case "1":
                case "checkout":
                    paymentDialog();
                    break;
                case "2":
                case "shop":
                case "shop more":
                    homepage.homepageMenuDialog();
                    break;
                case "3":
                case "remove":
                case "remove items":
                    removeItem();
                    break;
                default:
                    ui.displayMsg("Seems like you made a typo, try again\n");
                    CartDialog();
                    break;
            }
        }

        public int getTotalPrice(){
            int total = 0;
            for (Clothing c : itemsInCart){
                total += c.price;
            }
            return total;
        }

        public void paymentDialog() {
            displayCart();
            db.readUserData();
            ui.displayMsg("\nYour total is: " + getTotalPrice() + "$\n");

            String input = "";
            ui.displayMsg("Would you like to Login or register payment information? ");

            input = ui.getInput("Press 'L' for Login or 'R' to add payment information");
            ui.displayMsg(" ");
            if (!input.equalsIgnoreCase("L")) {
                addPaymentDetails();
            }
            else {
                if (homepage.isLoggedIn()){
                    homepage.login();
                }
            }
            // Perform the transaction

            ui.displayMsg("\n Verifying card or number");
            ui.displayMsg("");

            ui.displayMsg("Congratulations, your payment have been approved. \nHere is your receipt:");
            displayCart();
            ui.displayMsg("Total: " + getTotalPrice() + "$\n");


            removeStock();
            clearCart();
        }

        private void addPaymentDetails() {

            String inputName = ui.getInput("Enter your Name:");
            String inputEmail = ui.getInput("Enter your e-mail");
            String inputAddress = ui.getInput("Enter delivery adress");

            ui.displayMsg("");
            ui.displayMsg("Is the info correct? ");
            ui.displayMsg("");
            System.out.println(" Name: " + inputName + "\n Email:  " + inputEmail + "\n Delivery Address  " + inputAddress);

            ui.displayMsg("");
            String correction = "";
            correction = ui.getInput("Pres 'Y' for yes and 'N' for no");

            if (correction.equalsIgnoreCase("Y")) {
                User user = new User(inputName, inputEmail, inputAddress);
                db.guestUser.add(user);
                System.out.println("Super! Moving on to the payment");
            } else {
                System.out.println("Lets try again");
                addPaymentDetails();

            }

            String input = "";
            ui.displayMsg("\n Would you like to pay with card? or Mobilepay? ");
            input = ui.getInput("Pres 'C' for card or 'M' for Mobilepay");
            ui.displayMsg("");

            if (input.equalsIgnoreCase("C")) {
                int inputRegNr;
                do {
                    inputRegNr = Integer.parseInt(ui.getInput("Enter registration number"));
                    if (inputRegNr != 4) {
                        System.out.println("The registration number is incorrect, try again");
                    }
                } while (inputRegNr != 4);

                int inputAccountNr;
                do {
                    inputAccountNr = Integer.parseInt(ui.getInput("Enter account number"));
                    if (inputAccountNr != 10) {
                        System.out.println("The account number is incorrect, try again");
                    }
                } while (inputAccountNr != 10);
            } else if (input.equalsIgnoreCase("M")) {
                int phoneNumber;
                do {
                    phoneNumber = Integer.parseInt(ui.getInput("Enter your phone number (8 numbers)"));
                    if (String.valueOf(phoneNumber).length() != 8) {
                        System.out.println("The number does not have 8 digits, try again");
                    }
                } while (String.valueOf(phoneNumber).length() != 8);
            }
        }

        private ArrayList<Clothing> removeStock() {
            ArrayList<Clothing> removeStockList = new ArrayList<Clothing>();
            for (Clothing clothing : itemsInCart) {
                removeStockList.add(clothing);
            }
            return removeStockList;
        }

        private void addItem(Clothing clothing){
            itemsInCart.add(clothing);
        }

        private void removeItem(){
            //String response = ui.getInput("Name the item you want removed");
            int response = ui.getNumericInput("Type the ID of the item you want removed");
            Iterator<Clothing> iterator = itemsInCart.iterator();

            while (iterator.hasNext()){
                Clothing clothing = iterator.next();
                if(clothing.getID() == response){
                    iterator.remove();
                } else {
                    ui.displayMsg("Seems like the product id you typed doesn't exist, try again");
                    removeItem();
                }
            }
            ui.displayMsg("The product was successfully removed");
            CartDialog();
        }

        private void clearCart(){
            itemsInCart.clear();
        }
}




