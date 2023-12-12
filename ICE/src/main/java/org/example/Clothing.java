package org.example;
public class Clothing {
    protected int ID;
    protected String name;
    protected float price;
    protected float discountPrice;
    protected int stock;
    protected String type;
    protected String brand;
    protected String gender;

    public Clothing(int ID, String name, float price, float discountPrice, int stock, String type, String brand, String gender) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.type = type;
        this.brand = brand;
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public int getStock() {
        return stock;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getGender() {
        return gender;
    }

    public String toString(){
        return "Clothing ID: " + ID + " | Name: " + name + " | Price: " + price + " | Discount price (if discount=true): " + discountPrice + "\nStock: " + stock + " | Type: " + type + " | Brand: " + brand + " | Gender: " + gender;
    }
}
