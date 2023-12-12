package org.example;

public class Pants extends Clothing{
    protected int size;

    public Pants(int ID, String name, float price, float discountPrice, int stock, String type, String brand, String gender, int size) {
        super(ID, name, price, discountPrice, stock, type, brand, gender);
        this.size = size;
    }
    @Override
    public String toString(){
        return "Clothing ID: " + ID + " | Name: " + name + " | Price: " + price + " | Discount price (if discount=true): " + discountPrice + " | Size: " + size + "\nStock: " + stock + " | Type: " + type + " | Brand: " + brand + " | Gender: " + gender;
    }
}
