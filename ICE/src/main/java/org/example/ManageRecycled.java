package org.example;

public class ManageRecycled {
    TextUI ui = new TextUI();
    DBConnector db = new DBConnector();
    int price;
    int stock;
    String type;
    String brand;
    String gender;
    String color;
    String model;


    public ManageRecycled(int price, String type, String brand, String gender, String color) {
        this.price = price;
        this.type = type;
        this.brand = brand;
        this.gender = gender;
        this.color = color;
    }

        private void sellingDialog () {
            ui.displayMsg("");
            ui.displayMsg(" Welcome to the Recyclingpage, where we sell your old clothing.\n Let's get startet. ");

            registerClothing();


        }

        private void registerClothing () {

            String inputType = ui.getInput(" Enter the clothing type:");
            String inputBrand = ui.getInput(" Enter clothing brand");
            String inputGender = ui.getInput(" Enter gender category");
            String inputColor = ui.getInput("Enter clothing color");

          String input = ui.getInput(" Are the information correct? : " + inputType + inputBrand + inputGender+ inputColor + "\n Pres 'Y' for yes and 'N' for no.");

          if (input.equalsIgnoreCase("Y")){
              ui.displayMsg("\n Perfect lets register the clothing in our system");
          } else if (input.equalsIgnoreCase("N")) {
              ui.displayMsg("Try again");
              registerClothing();
          }

            // add a Insert i dbconnector.
            db.saveRecyledData(inputType, inputBrand, inputGender, inputColor);

            ui.displayMsg("\n The clothing is now registered");

            paymentCalculator();

        }

        private void paymentCalculator () {
            int inputOldprice = Integer.parseInt(ui.getInput(" Enter the old price, for the clothing. Price is in $. "));

            double returnPrice = 0.35 * inputOldprice;
            ui.displayMsg("\n We have now calculated a price, we would like to pay for the clothing you have registered: " + returnPrice);

            String input = ui.getInput("Would you like to accept this offer? Pres 'Y' for Yes and 'N' for no ");

            if (input.equalsIgnoreCase("Y")){
                ui.displayMsg(" Super. Starting transaction");
                receiptAndTransactionDialog ();
            }
            else {
                ui.displayMsg("Unfortunately we cannot offer a different price for the clothes.");
                //find ud af hvad der skal ske her.
            }


        }

    private void receiptAndTransactionDialog() {
       // lav et metode der sørger for pengene bliver "overført til kunden" og de får en kvittering



    }
    

}


