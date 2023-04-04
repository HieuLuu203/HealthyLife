package com.example.healthylife.Model;

//import androidx.room.Entity;
//import androidx.room.PrimaryKey;

import com.example.healthylife.ItemDialog.DialogModel;

import java.util.ArrayList;
import java.util.List;

//@Entity (tableName = "plan")

public class Plan {
//    @PrimaryKey(autoGenerate = true)
    String day;
    private int id;
    List<DialogModel> breakfast = new ArrayList<>();
    List<DialogModel> lunch = new ArrayList<>();
    List<DialogModel> dinner = new ArrayList<>();

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<DialogModel> getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(List<DialogModel> breakfast) {
        this.breakfast = breakfast;
    }

    public List<DialogModel> getLunch() {
        return lunch;
    }

    public void setLunch(List<DialogModel> lunch) {
        this.lunch = lunch;
    }

    public List<DialogModel> getDinner() {
        return dinner;
    }

    public void setDinner(List<DialogModel> dinner) {
        this.dinner = dinner;
    }

    public void addBreakfast(DialogModel item) {
       breakfast.add(item);
   }

    public void addLunch(DialogModel item) {
         lunch.add(item);
    }

    public void addDinner(DialogModel item) {
         dinner.add(item);
    }

    public void setMeal(List<DialogModel> listMeal, String meal) {
        if (meal.equals("breakfast")) setBreakfast(listMeal);
        else if (meal.equals("lunch")) setLunch(listMeal);
        else setDinner(listMeal);
    }

    public DialogModel getFood (String meal, DialogModel food)
    {
        List <DialogModel> tmp;
        if (meal.equals("breakfast")) tmp = this.breakfast;
        else if (meal.equals("lunch")) tmp = this.lunch;
        else tmp = this.dinner;
        for (DialogModel i : tmp)
        {
            if (i.getFoodName().equals(food.getFoodName())) return i;
        }
        return food;
    }
}
