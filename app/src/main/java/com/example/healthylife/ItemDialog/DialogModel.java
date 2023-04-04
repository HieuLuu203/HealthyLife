package com.example.healthylife.ItemDialog;

import android.widget.CheckBox;

public class DialogModel {
    private String foodName;
    private int foodCalories, number;

    public boolean isChecked = false;

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
            case "Pasta":
                this.foodCalories = 130 * number;
                break;
            case "Bread":
                this.foodCalories = 64 * number;
                break;
            case "Potato":
                this.foodCalories = 77 * number;
                break;
            case "Tomato":
                this.foodCalories = 18 * number;
                break;
            case "Cucumber":
                this.foodCalories = 15 * number;
                break;
            case "Carrot":
                this.foodCalories = 41 * number;
                break;
            case "Spinach":
                this.foodCalories = 23 * number;
                break;
            case "Cabage":
                this.foodCalories = 25 * number;
                break;


        }
    }

    public String getFoodName() {
        return foodName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
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
