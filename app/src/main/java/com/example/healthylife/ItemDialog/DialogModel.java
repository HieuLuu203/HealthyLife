package com.example.healthylife.ItemDialog;

import android.media.Image;
import android.widget.CheckBox;

import com.example.healthylife.R;

public class DialogModel {
    private String foodName;

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    private int foodImage;
    private int foodCalories, number;

    public boolean isChecked = false;

    public DialogModel(String foodName) {
        this.foodName = foodName;
        this.number = 0;
        switch (foodName)
        {
            case "Apple":
                this.foodCalories = 52 * number;
                this.foodImage = R.drawable.apple;
                break;
            case "Banana":
                this.foodCalories = 89 * number;
                this.foodImage = R.drawable.banana;
                break;
            case "Orange":
                this.foodCalories = 47 * number;
                this.foodImage = R.drawable.orange;
                break;
            case "Milk":
                this.foodCalories = 42 * number;
                this.foodImage = R.drawable.milk;
                break;
            case "Egg":
                this.foodCalories = 78 * number;
                this.foodImage = R.drawable.egg;
                break;
            case "Chicken":
                this.foodCalories = 165 * number;
                this.foodImage = R.drawable.chicken;
                break;
            case "Beef":
                this.foodCalories = 240 * number;
                this.foodImage = R.drawable.beef;
                break;
            case "Pork":
                this.foodCalories = 250 * number;
                this.foodImage = R.drawable.pork;
                break;
            case "Fish":
                this.foodCalories = 208 * number;
                this.foodImage = R.drawable.fish;
                break;
            case "Rice":
                this.foodCalories = 130 * number;
                this.foodImage = R.drawable.rice;
                break;
            case "Pasta":
                this.foodCalories = 130 * number;
                this.foodImage = R.drawable.pasta;
                break;
            case "Bread":
                this.foodCalories = 64 * number;
                this.foodImage = R.drawable.bread;
                break;
            case "Potato":
                this.foodCalories = 77 * number;
                this.foodImage = R.drawable.potato;
                break;
            case "Tomato":
                this.foodCalories = 18 * number;
                this.foodImage = R.drawable.tomato;
                break;
            case "Cucumber":
                this.foodCalories = 15 * number;
                this.foodImage = R.drawable.cucumber;
                break;
            case "Carrot":
                this.foodCalories = 41 * number;
                this.foodImage = R.drawable.carrot;
                break;
            case "Spinach":
                this.foodCalories = 23 * number;
                this.foodImage = R.drawable.spinach;
                break;
            case "Cabbage":
                this.foodCalories = 25 * number;
                this.foodImage = R.drawable.cabbage;
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
