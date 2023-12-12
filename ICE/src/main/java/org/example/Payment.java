package org.example;
    import java.util.Scanner;

    public class Payment {
        private int paymentID;
        private double amount;
        //Should it be final??
        private final TextUI ui = new TextUI();
        //private final User u = new User();

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
            transactionDialog();
        }

        private void addPaymentDetails() {
            String inputName = ui.getInput("Enter your username:");
            String inputPassword = ui.getInput("Enter your password:");
            String inputEmail = ui.getInput("Enter your e-mail");
            String inputAdress = ui.getInput("Enter delivery adress");

            String input = "";
            ui.displayMsg("\n Would you like to pay with card? or Mobilepay? ");
            input = ui.getInput("Pres 'C' for card or 'M' for Mobilepay");
            ui.displayMsg("");
            if (input.equalsIgnoreCase("C")) {
                int inputRegNr = Integer.parseInt(ui.getInput("Enter registration number"));
                while (!(inputRegNr == 4)) {
                    System.out.println("The registration number is incorrect, try again");
                    inputRegNr = Integer.parseInt(ui.getInput("Enter registration number"));
                }
                    int inputAccountNr = Integer.parseInt(ui.getInput("Enter account number"));
                    if (!(inputAccountNr ==10)){
                        System.out.println("The account number is incorrect, try again");
                        inputAccountNr = Integer.parseInt(ui.getInput("Enter registration number"));
                    }
                }
                ui.displayMsg("Is the info corect? ");

                System.out.println("Name: " + inputName + "\n  Email:  " + inputEmail + "\n Delivery Adress  " + inputAdress);


            } else if (input.equalsIgnoreCase("M")) {

                int phoneNumber = Integer.parseInt(ui.getInput("Enter your phone number, 8 numbers"));
                if (phoneNumber < 8) {
                    System.out.println("The phone number does not exist, try again");
                    phoneNumber = Integer.parseInt(ui.getInput("Enter your phone number with, 8 number"));
                }

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
