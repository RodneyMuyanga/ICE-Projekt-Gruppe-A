package org.example;

public class Sneakers extends Clothing {
    protected int size;

    public Sneakers(int ID, int price, int discountPrice, int stock, String type, String brand, String gender, int size,  String color, String model) {
        super(ID, price, discountPrice, stock, type, brand, gender, model, color);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Sneakers ID: " + ID + " | Price: " + price + "$" +  " | Member discount: " + discountPrice + "$" + " | Size: " + size + "\nStock: " + stock + " | Type: " + type + " | Brand: " + brand + "Model: " + model + " | Gender: " + gender + " | Color: " + color+"\n";
    }
}