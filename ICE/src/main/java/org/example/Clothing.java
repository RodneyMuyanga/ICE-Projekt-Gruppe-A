package org.example;
public class Clothing {
    protected int ID;
    protected int price;
    protected int discountPrice;
    protected int stock;
    protected String type;
    protected String brand;
    protected String gender;
    protected String size;
    protected String color;
    protected String model;

    //kald clothing for products
    public Clothing(int ID, int price, int discountPrice, int stock, String type, String brand, String gender, String color, String model) {
        this.ID = ID;
        this.price = price;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.type = type;
        this.brand = brand;
        this.gender = gender;
        this.color = color;
        this.model = model;
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountPrice() {
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
    public String getSize() { return size; }
    public String getColor(){return color;}
    public String getModel(){return model;}

    public String toString(){
        return "Clothing ID: " + ID + " | Price: " + price + "$" + " | Discount price (if discount=true): " + discountPrice + "$" + " | Size: " + size + "\nStock: " + stock + " | Type: " + type +  " | Brand: " + brand + " | Model: " + model + " | Gender: " + gender + " | Color: " + color;
    }

}