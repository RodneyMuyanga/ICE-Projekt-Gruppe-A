//package org.example;
//
//public class ManageRecycled {
//    TextUI ui = new TextUI();
//    DBConnector db = new DBConnector();
//    Homepage homepage = new Homepage();
//
//
//    public void sellingDialog () {
//        if (homepage.isLoggedIn()) {
//            ui.displayMsg("");
//
//            ui.displayMsg("Welcome " + homepage.currentUser + " to the Recyclingpage, where we sell your old clothing.\nLet's get started.");
//        } else {
//            ui.displayMsg("Please login or register as a user in order to sell clothes");
//            String choice = ui.getInput("[1] Log in \n[2] Register user");
//            if (choice.equals("1")){
//            homepage.login();
//            }
//            else {
//                homepage.createAccount();
//            }
//
//        }
//
//        registerClothing();
//    }
//    public String askGender(){
//        return ui.getInput("Enter gender Men/Women");
//    }
//
//    public String askSize(){
//        return ui.getInput("Enter the size in XS, S, M, L, XL and XXL");
//    }
//
//    public void registerClothing () {
//        String inputBrand = ui.getInput("Enter clothing brand");
//        inputBrand = inputBrand.substring(0, 1).toUpperCase() + inputBrand.substring(1);
//
//        String inputModel = ui.getInput("Enter model name");
//        inputModel = inputModel.substring(0, 1).toUpperCase() + inputModel.substring(1);
//
//        String inputGender;
//        do {
//            inputGender = askGender();
//            inputGender = inputGender.substring(0, 1).toUpperCase() + inputGender.substring(1);
//            if (!(inputGender.equalsIgnoreCase("Men") || inputGender.equalsIgnoreCase("Women"))) {
//                ui.displayMsg("ENTER MEN OR WOMEN!");
//            }
//        } while (!(inputGender.equalsIgnoreCase("Men") || inputGender.equalsIgnoreCase("Women")));
//
//
//        String inputSize;
//        do {
//            inputSize = askSize();
//            inputSize = inputSize.toUpperCase();
//            if (!(inputSize.equals("XS") || inputSize.equals("S") || inputSize.equals("M") || inputSize.equals("L") || inputSize.equals("XL") || inputSize.equals("XXL"))) {
//                ui.displayMsg("Enter the size in XS, S, M, L, XL and XXL");
//            }
//        } while (!(inputSize.equals("XS") || inputSize.equals("S") || inputSize.equals("M") || inputSize.equals("L") || inputSize.equals("XL") || inputSize.equals("XXL")));
//
//
//        String inputColor = ui.getInput("Enter clothing color");
//        inputColor = inputColor.substring(0, 1).toUpperCase() + inputColor.substring(1);
//
//        ui.displayMsg("");
//        String input = ui.getInput("Are the information correct? : \n"+ " Brand: " + inputBrand + "\n Model: " + inputModel + "\n Gender: "  + inputGender + "\n Size: " + inputSize + "\n Color: " + inputColor + "\n\nPress 'Y' for yes and 'N' for no.");
//
//        if (input.equalsIgnoreCase("Y")){
//            //db.RecyclingClothes.add( clothing);
//            //ui.displayMsg("\n Perfect lets register the clothing in our system");
//
//        } else if (input.equalsIgnoreCase("N")) {
//            ui.displayMsg("Try again");
//            registerClothing();
//        }
//
//
//        ui.displayMsg("\nThe clothing is now registered");
//
//        //paymentCalculator();
//
//        int sellPrice = paymentCalculator();
//        RecycledClothes recycledClothing = new RecycledClothes(inputBrand,inputModel,inputGender,inputSize,inputColor,sellPrice);
//        db.saveRecycledClothes(inputBrand,inputModel,inputGender,inputSize,inputColor,sellPrice);
//
//    }
//
//    public int paymentCalculator () {
//        int inputOldPrice = ui.getNumericInput("Enter the old price, for the clothing in $. ");
//
//        double returnPrice = 0.35 * inputOldPrice;
//        double sellPrice = 0.90 * inputOldPrice;
//
//        ui.displayMsg("\nYou will get: " + returnPrice + "$ for your product");
//        String input = ui.getInput("\nWould you like to accept this offer or decline? Pres 'Y' for Yes and 'N' for no ");
//
//        if (input.equalsIgnoreCase("Y")){
//            ui.displayMsg("\nWe will now send a e-mail to " + homepage.currentUser.getEmail() + " with next steps.\nThank you for choosing Renewed Couture GangGang Corner ");
//
//        }
//        else if (input.equalsIgnoreCase("N")) {
//            {
//                ui.displayMsg("Unfortunately we cannot offer a different price for the clothes. Please try again");
//                //paymentCalculator();
//            }
//        }
//        return (int) sellPrice;
//    }
//
//
//
//
//    /*public boolean isLoggedIn() {
//        if (h.currentUser != null) {
//            return true;
//        } else {
//            return false;
//        }
//    }*/
//}
//
//
//
