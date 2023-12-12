package org.example;
import java.util.ArrayList;

public class Homepage {
    private final TextUI ui = new TextUI();
    //private final DBConnector db = new DBConnector();
    private ArrayList<String> homeMenu = new ArrayList<>();
    private ArrayList<String> menClothingMenu = new ArrayList<>();

    Homepage() {

    }

    public void setup() {
        homepageMenu();
        homepageMenuDialog();
        //chooseMenMenu();
    }

    public void homepageMenu() {
        homeMenu.add("[1] Men");
        homeMenu.add("[2] Women");
        homeMenu.add("[3] Kids");
        homeMenu.add("[4] Recycled Clothing");
        homeMenu.add("[5] Login/Create account");
    }

    public void homepageMenuDialog() {
        ui.displayMsg("Welcome to Renewed Couture GangGang Corner\n Choose a category");
        for (int i = 0; i < homeMenu.size(); i++) {
            ui.displayMsg(homeMenu.get(i));
        }
        String response = ui.getInput("");

        switch (response.toLowerCase()) {
            case "1":
            case "men":
            case "men clothing":
                System.out.println("Men clothing");
                break;
            case "2":
            case "woman":
            case "woman clothing":
                System.out.println("Woman clothing");
                break;
            case "3":
            case "kids":
            case "kids clothing":
                System.out.println("Kids clothing");
                break;
            case "4":
            case "recycled":
            case "recycled clothing":
                System.out.println("Recycled clothing");
                break;
            case "5":
            case "login":
            case "logout":
                System.out.println("Do you want to login or create a new account?");
                break;
            default:
                ui.displayMsg("Seems like you made a typo, try again");
                homepageMenuDialog();
                break;
        }
    }

    public void chooseMenMenu() {
        menClothingMenu.add("All clothes");
        menClothingMenu.add("Jackets");
        menClothingMenu.add("Hoodies");
        menClothingMenu.add("T-shirts");
        menClothingMenu.add("Pants");
        menClothingMenu.add("Sneakers");
        menClothingMenu.add("Boots");
        menClothingMenu.add("Back");
    }

    public void chooseMenSelection() {
        ui.displayMsg("Men's Clothing Menu:");
        for (int i = 0; i < menClothingMenu.size(); i++) {
            ui.displayMsg((i + 1) + ". " + menClothingMenu.get(i));
        }
            String response = ui.getInput("");


            switch (response.toLowerCase()) {
                case "1":
                case "all clothes":
                    ui.displayMsg("Displaying all clothes\n");
                    System.out.println(db.getClothes);
                    break;
                case "2":
                case "jackets":
                    ui.displayMsg("Displaying all jackets\n");
                    chooseMenJackets();
                    break;
                case "3":
                case "hoodies":
                    ui.displayMsg("Displaying all hoodies\n");
                    chooseMenHoodies();
                    break;
                case "4":
                case "t-shirts":
                    ui.displayMsg("Displaying all T-shirts\n");
                    chooseMenTshirts();
                    break;
                case "5":
                case "pants":
                    ui.displayMsg("Displaying all pants\n");
                    chooseMenPants();
                    break;
                case "6":
                case "sneakers":
                    ui.displayMsg("Displaying all sneakers\n");
                    chooseMenSneakers();
                    break;
                case "7":
                case "boots":
                    ui.displayMsg("Displaying all boots\n");
                    chooseMenBoots();
                    break;
                case "8":
                case "back":
                    ui.displayMsg("Returning back to the homemenu...");
                    homepageMenuDialog();
                    break;
                default:
                    ui.displayMsg("Try again");
                    chooseMenSelection();
            }
        }
    }
}
