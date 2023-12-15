package org.example;

import java.util.ArrayList;

public class ClothingSelection {
    protected TextUI ui = new TextUI();
    private ArrayList<String> chooseClothingMenu = new ArrayList<>();
    private ArrayList<String> chooseRecycledClothingMenu = new ArrayList<>();
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
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                ui.displayMsg("");
                return chooseMenSelection();
        }
        return null;
    }

    public ArrayList<Clothing> chooseWomenSelection() {
        ui.displayMsg("Women's Clothing Menu:");
        for (int i = 0; i < chooseClothingMenu.size(); i++) {
            ui.displayMsg((i + 1) + ". " + chooseClothingMenu.get(i));
        }
        String response = ui.getInput("");

        switch (response.toLowerCase()) {
            case "1":
            case "all clothes":
                ui.displayMsg("Displaying all boots\n");
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
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again\n");
                ui.displayMsg("");
                return chooseWomenSelection();
        }
        return null;
    }

    public ArrayList<Clothing> chooseKidsSelection() {
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
                ui.displayMsg("Returning back to the home-menu...");
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
