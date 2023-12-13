package org.example;

import java.util.ArrayList;

public class ClothingSelection {
    protected TextUI ui = new TextUI();
    private ArrayList<String> chooseClothingMenu = new ArrayList<>();
    protected ArrayList<Clothing> chosenClothes;
    DBConnector db = new DBConnector();

    public ClothingSelection() {
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

    public ArrayList<Clothing> chooseMenSelection() {
        chooseClothingMenu();
        ui.displayMsg("Men's Clothing Menu:");
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
            //break;
            case "7":
            case "boots":
                ui.displayMsg("Displaying all boots\n");
                db.readMenBoots();
                for (Clothing clothing : db.getBootsForMen()) {
                    System.out.println(clothing);
                }
                ui.displayMsg("");
                return this.chosenClothes = db.getBootsForMen();
            //break;
            case "8":
            case "back":
                ui.displayMsg("Returning back to the home-menu...");
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                ui.displayMsg("");
                chooseMenSelection();
                break;
        }
        return null;
    }


    /*public void chooseWomenSelection() {
        ui.displayMsg("Women's Clothing Menu:");
        for (int i = 0; i < chooseClothingMenu.size(); i++) {
            ui.displayMsg((i + 1) + ". " + chooseClothingMenu.get(i));
        }
        String response = ui.getInput("");


        switch (response.toLowerCase()) {
            case "1":
            case "all clothes":
                ui.displayMsg("Displaying all clothes\n");
                System.out.println(db.getWomenClothes);
                break;
            case "2":
            case "jackets":
                ui.displayMsg("Displaying all jackets\n");
                db.getWomenJackets();
                break;
            case "3":
            case "hoodies":
                ui.displayMsg("Displaying all hoodies\n");
                db.getWomenHoodies();
                break;
            case "4":
            case "t-shirts":
                ui.displayMsg("Displaying all T-shirts\n");
                db.getWomenTshirts();
                break;
            case "5":
            case "pants":
                ui.displayMsg("Displaying all pants\n");
                db.getWomenPants();
                break;
            case "6":
            case "sneakers":
                ui.displayMsg("Displaying all sneakers\n");
                db.getWomenSneakers();
                break;
            case "7":
            case "boots":
                ui.displayMsg("Displaying all boots\n");
                db.getWomenBoots();
                break;
            case "8":
            case "back":
                ui.displayMsg("Returning back to the home-menu...");
                h.backToHomepage();
                break;
            default:
                ui.displayMsg("Try again");
                chooseWomenSelection();
        }
    }

public void chooseKidsSelection() {
        ui.displayMsg("Kids Clothing Menu:");
        for (int i = 0; i < chooseClothingMenu.size(); i++) {
            ui.displayMsg((i + 1) + ". " + chooseClothingMenu.get(i));
        }
        String response = ui.getInput("");


        switch (response.toLowerCase()) {
            case "1":
            case "all clothes":
                ui.displayMsg("Displaying all clothes\n");
                System.out.println(db.getKidsClothes);
                break;
            case "2":
            case "jackets":
                ui.displayMsg("Displaying all jackets\n");
                db.getKidsJackets();
                break;
            case "3":
            case "hoodies":
                ui.displayMsg("Displaying all hoodies\n");
                db.getKidsHoodies();
                break;
            case "4":
            case "t-shirts":
                ui.displayMsg("Displaying all T-shirts\n");
                db.getKidsTshirts();
                break;
            case "5":
            case "pants":
                ui.displayMsg("Displaying all pants\n");
                db.getKidsPants();
                break;
            case "6":
            case "sneakers":
                ui.displayMsg("Displaying all sneakers\n");
                db.getKidsSneakers();
                break;
            case "7":
            case "boots":
                ui.displayMsg("Displaying all boots\n");
                db.getKidsBoots();
                break;
            case "8":
            case "back":
                ui.displayMsg("Returning back to the home-menu...");
                h.backToHomepage();
                break;
            default:
                ui.displayMsg("Try again");
                chooseKidsSelection();
        }
    }

    public void chooseRecycledSelection() {
        ui.displayMsg("Recycled Clothing Menu:");
        for (int i = 0; i < chooseClothingMenu.size(); i++) {
            ui.displayMsg((i + 1) + ". " + chooseClothingMenu.get(i));
        }
        String response = ui.getInput("");


        switch (response.toLowerCase()) {
            case "1":
            case "all clothes":
                ui.displayMsg("Displaying all clothes\n");
                System.out.println(db.getRecycledClothes);
                break;
            case "2":
            case "jackets":
                ui.displayMsg("Displaying all jackets\n");
                db.getRecycledJackets();
                break;
            case "3":
            case "hoodies":
                ui.displayMsg("Displaying all hoodies\n");
                db.getRecycledHoodies();
                break;
            case "4":
            case "t-shirts":
                ui.displayMsg("Displaying all T-shirts\n");
                db.getRecycledTshirts();
                break;
            case "5":
            case "pants":
                ui.displayMsg("Displaying all pants\n");
                db.getRecycledPants();
                break;
            case "6":
            case "sneakers":
                ui.displayMsg("Displaying all sneakers\n");
                db.getRecycledSneakers();
                break;
            case "7":
            case "boots":
                ui.displayMsg("Displaying all boots\n");
                db.getRecycledBoots();
                break;
            case "8":
            case "back":
                ui.displayMsg("Returning back to the home-menu...");
                h.backToHomepage();
                break;
            default:
                ui.displayMsg("Try again");
                chooseRecycledSelection();
        }
    }*/

    public ArrayList<Clothing> getChosenClothes() {
        return chosenClothes;
    }
}

