package org.example;
public class Jacket extends Clothing{
    protected String size;

    public Jacket(int ID, int price, int discountPrice, int stock, String type, String brand, String gender, String size, String color, String model) {
        super(ID, price, discountPrice, stock, type, brand, gender, color, model);
        this.size = size;
    }

    public String getSize(){
        return size;
    }
    @Override
    public String toString(){
        return "Clothing ID: " + ID + " | Price: " + price + " | Discount price (if discount=true): " + discountPrice + " | Size: " + size + "Stock: " + stock + " | Type: " + type +  " | Brand: " + brand + " | Model: " + model + " | Gender: " + gender + " | Color: " + color;    }
}

