package com.example.healthylife.Model;

public class Plan {
    String day, foodName;
    int foodCalories, number;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodCalories() {
        return foodCalories;
    }

    public void setFoodCalories(int foodCalories) {
        this.foodCalories = foodCalories;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return day + " " + foodName + " " + foodCalories + " " + number;
    }
}
