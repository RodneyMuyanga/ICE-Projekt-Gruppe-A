package org.example;

import java.util.ArrayList;

public class ClothingSelection {
    private final TextUI ui = new TextUI();
    private final Homepage h = new Homepage();
    private ArrayList<String> chooseClothingMenu;
    public ClothingSelection(){
        this.chooseClothingMenu = new ArrayList<>();
    }

    public void chooseClothingMenu() {
        chooseClothingMenu.add("All clothes");
        chooseClothingMenu.add("Jackets");
        chooseClothingMenu.add("Hoodies");
        chooseClothingMenu.add("T-shirts");
        chooseClothingMenu.add("Pants");
        chooseClothingMenu.add("Sneakers");
        chooseClothingMenu.add("Boots");
        chooseClothingMenu.add("Back");
    }
    public void chooseMenSelection() {
        ui.displayMsg("Men's Clothing Menu:");
        for (int i = 0; i < chooseClothingMenu.size(); i++) {
            ui.displayMsg((i + 1) + ". " + chooseClothingMenu.get(i));
        }
        String response = ui.getInput("");


        switch (response.toLowerCase()) {
            case "1":
            case "all clothes":
                ui.displayMsg("Displaying all clothes\n");
                System.out.println(db.getMenClothes);
                break;
            case "2":
            case "jackets":
                ui.displayMsg("Displaying all jackets\n");
                db.getMenJackets();
                break;
            case "3":
            case "hoodies":
                ui.displayMsg("Displaying all hoodies\n");
                db.getMenHoodies();
                break;
            case "4":
            case "t-shirts":
                ui.displayMsg("Displaying all T-shirts\n");
                db.getMenTshirts();
                break;
            case "5":
            case "pants":
                ui.displayMsg("Displaying all pants\n");
                db.getMenPants();
                break;
            case "6":
            case "sneakers":
                ui.displayMsg("Displaying all sneakers\n");
                db.getMenSneakers();
                break;
            case "7":
            case "boots":
                ui.displayMsg("Displaying all boots\n");
                db.getMenBoots();
                break;
            case "8":
            case "back":
                ui.displayMsg("Returning back to the home-menu...");
                h.backToHomepage();
                break;
            default:
                ui.displayMsg("Try again");
                chooseMenSelection();
        }
    }

    public void chooseWomenSelection() {
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
    }
}
