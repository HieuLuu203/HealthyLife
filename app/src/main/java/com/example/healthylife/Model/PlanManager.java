package com.example.healthylife.Model;

import com.example.healthylife.ItemDialog.DialogModel;

import java.util.ArrayList;
import java.util.List;

enum Weekday {
    Mon, Tue, Wed, Thu, Fri, Sa, Sun
}

public class PlanManager {
    private static List<Plan> list = new ArrayList<>();
    public static PlanManager instance;

    private PlanManager() {
        for (Weekday i : Weekday.values()) {
            Plan plan = new Plan();
            plan.setDay(i.toString());
            list.add(plan);
        }
        System.out.println(list.size());
    }

    public static PlanManager getInstance() {
        if (instance == null)
            instance = new PlanManager();
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
        for (Plan i : list)
            if (i.getDay().equals(day)) i = plan;
    }

}
