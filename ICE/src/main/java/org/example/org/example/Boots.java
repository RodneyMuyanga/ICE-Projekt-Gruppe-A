package org.example;
public class Boots extends Clothing{
    protected int size;

    public Boots(int ID, int price, int discountPrice, int stock, String type, String brand, String gender, int size, String color, String model) {
        super(ID,price, discountPrice, stock, type, brand, gender, color, model);
        this.size = size;
    }
    @Override
    public String toString(){
        return "Clothing ID: " + ID + " | Price: " + price + "$" + " | Discount price (if discount=true): " + discountPrice + "$" + " | Size: " + size + "\nStock: " + stock + " | Type: " + type +  " | Brand: " + brand + " | Model: " + model + " | Gender: " + gender + " | Color: " + color;

    }
}

