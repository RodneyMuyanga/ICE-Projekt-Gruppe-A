package org.example;
    import java.util.Scanner;

    public class Payment {
        private int paymentID;
        private double amount;

        //private final User u = new User();
        private final TextUI ui = new TextUI();
        //private final DBConnector db = new DBConnector();

        // Constructor
        public Payment(int paymentID, double amount) {
            this.paymentID = paymentID;
            this.amount = amount;
        }

        // Method to handle payment dialog
        public void paymentDialog() {
            String input = "";
            ui.displayMsg("\n Would you like to Login or registre payment informations? ");
            input = ui.getInput("Press 'L' for Login or 'R' to add payment information");
            ui.displayMsg(" ");
            if (!input.equalsIgnoreCase("L")) {
                addPaymentDetails();
            }
            else {
                //get.UserInfo
            }
            // Display the cart
            displayCart();
            // Perform the transaction
        }

        private void addPaymentDetails() {
            String inputName = ui.getInput("Enter your username:");
            String inputPassword = ui.getInput("Enter your password:");
            String inputEmail = ui.getInput("Enter your e-mail");
            String inputAdress = ui.getInput("Enter delivery adress");

            ui.displayMsg("Is the info corect? ");

            System.out.println("Name: " + inputName + "\n  Email:  " + inputEmail + "\n Delivery Adress  " + inputAdress);

            String correction = "";
            correction = ui.getInput("Pres 'Y' for yes and 'N' for no");

            if (correction.equalsIgnoreCase("Y")) {
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


        // Method to display the cart
        private void displayCart() {


        }

        // Method to handle the transaction
        private void transactionDialog() {

        }


        // Method to check card details and balance

        private void printReciept() {

        }

        private void removeStock() {
        }


    }
