package com.example.healthylife.Model;

import com.example.healthylife.ItemDialog.DialogModel;

import java.util.ArrayList;
import java.util.List;

enum Weekday {
    Mon, Tue, Wed, Thu, Fri, Sat, Sun
}

public class PlanManager {
    private List<Plan> list = new ArrayList<>();
    private static PlanManager instance;
    private int id;
    private void init(){
        for (Weekday i : Weekday.values()) {
            Plan plan = new Plan();
            plan.setDay(i.toString());
            list.add(plan);
        }
    }

    private PlanManager() {
    }

    public static PlanManager getInstance() {
        if (instance == null){
            System.out.println("Init PlanManager");
            instance = new PlanManager();
            instance.init();
        }
        return instance;
    }
    public void addPlan(Plan plan) {
        list.add(plan);
    }

    public void removePlan(Plan plan) {
        for (Plan i : list)
            if (i.getDay().equals(plan.getDay())) {
                list.remove(i);
                break;
            }
    }

    public List<Plan> getList() {
        return list;
    }

    public Plan getPlan(String day)
    {
        switch (day)
        {
            case "Mon":
                return list.get(0);
            case "Tue":
                return list.get(1);
            case "Wed":
                return list.get(2);
            case "Thu":
                return list.get(3);
            case "Fri":
                return list.get(4);
            case "Sat":
                return list.get(5);
            case "Sun":
                return list.get(6);
            default:
                return null;
        }
    }

    public void setPlan(Plan plan, String day)
    {
        for(int i = 0 ; i < list.size(); i++) {
            if (list.get(i).getDay().equals(day)) {
                list.get(i).setBreakfast(plan.getBreakfast());
                System.out.println(plan.getBreakfast().size());
            }
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
