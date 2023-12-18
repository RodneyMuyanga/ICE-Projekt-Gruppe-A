package org.example;

public class RecycledClothes extends Clothing{

protected String size;

    public RecycledClothes(String brand,String model, String gender, String size, String color, int price){
        super(0,price,0,1,null,brand,gender,color,model);
        this.size = size;
    }

    public RecycledClothes(int ID, String brand,String model, String gender, String size, String color, int price){
        super(ID,price,0,1,null,brand,gender,color,model);
        this.size = size;
    }

    public String toString(){
        return "Recycled clothing ID: " + ID + " | Brand: " + brand + " | Model: " + model + " | Gender: " + gender + " | Size: " + size + " | Color: " + color + " | Price: " + price+"\n";
    }
}
