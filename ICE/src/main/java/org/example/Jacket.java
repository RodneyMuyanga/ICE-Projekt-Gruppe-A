package org.example;
public class Jacket extends Clothing{
    protected String size;

    public Jacket(int ID, String name, float price, float discountPrice, int stock, String type, String brand, String gender, String size){
        super(ID, name, price, discountPrice, stock, type, brand, gender);
        this.size = size;
    }

    public String getSize(){
        return size;
    }
@Override
    public String toString(){
        return "Clothing ID: " + ID + " | Name: " + name + " | Price: " + price + " | Discount price (if discount=true): " + discountPrice + " | Size: " + size + "\nStock: " + stock + " | Type: " + type + " | Brand: " + brand + " | Gender: " + gender;
    }
}
