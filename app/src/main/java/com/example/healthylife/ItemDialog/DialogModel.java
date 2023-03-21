package com.example.healthylife.ItemDialog;

public class DialogModel {
    private String foodName;
    private int foodCalories, number;

    public DialogModel(String foodName) {
        this.foodName = foodName;
        this.number = 0;
        switch (foodName)
        {
            case "Apple":
                this.foodCalories = 52 * number;
                break;
            case "Banana":
                this.foodCalories = 89 * number;
                break;
            case "Orange":
                this.foodCalories = 47 * number;
                break;
            case "Milk":
                this.foodCalories = 42 * number;
                break;
            case "Egg":
                this.foodCalories = 78 * number;
                break;
            case "Chicken":
                this.foodCalories = 165 * number;
                break;
            case "Beef":
                this.foodCalories = 240 * number;
                break;
            case "Pork":
                this.foodCalories = 250 * number;
                break;
            case "Fish":
                this.foodCalories = 208 * number;
                break;
            case "Rice":
                this.foodCalories = 130 * number;
                break;


        }
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodCalories() {
        return foodCalories;
    }

    public int getNumber() {
        return number;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodCalories(int foodCalories) {
        this.foodCalories = foodCalories;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void increaseNumber() {this.number++;}

    public void decreaseNumber() {this.number--;}

}
