package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
    private final TextUI ui = new TextUI();
    private final DBConnector db = new DBConnector();

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
            ShoppingCartMenu.add("[3] Remove item(s)");
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
                // retunere til homepageMenu;
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
        else if (input.equalsIgnoreCase("L")){
            //homepage.login();
            return;
        }
        // Perform the transaction

        ui.displayMsg("\n Verifying card or number");

        ui.displayMsg("");

        ui.displayMsg("Congratulations, your payment have been approved. \nHere is your receipt:");
        displayCart();
        ui.displayMsg("Total: " + getTotalPrice() + "$\n");


        db.removeStock(itemsInCart);
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

    private void addItem(Clothing clothing){
        itemsInCart.add(clothing);
    }

    private void removeItem() {
        int response = ui.getNumericInput("Type the ID of the item you want to remove");
        int count = 0;

        // Count occurrences of the item with the given ID
        for (Clothing clothing : itemsInCart) {
            if (clothing.getID() == response) {
                count++;
            }
        }

        if (count > 0) {
            int removeCount = ui.getNumericInput("There are " + count + " items with that ID. How many do you want to remove?");

            // Remove specified number of items
            Iterator<Clothing> iterator = itemsInCart.iterator();
            int removed = 0;

            while (iterator.hasNext() && removed < removeCount) {
                Clothing clothing = iterator.next();
                if (clothing.getID() == response) {
                    iterator.remove();
                    removed++;
                }
            }
            ui.displayMsg("Successfully removed " + removed + " items with ID " + response);
        } else {
            ui.displayMsg("No items found with the specified ID.");
        }

        CartDialog();
    }


    private void clearCart(){
        itemsInCart.clear();
    }
}