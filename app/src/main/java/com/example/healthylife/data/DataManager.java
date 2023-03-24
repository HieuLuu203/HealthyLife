package com.example.healthylife.data;

import android.content.Context;

import com.example.healthylife.Model.Plan;
import com.google.gson.Gson;

public class DataManager {
    private static final String PREF_FIRST_INSTALL = "PREF_FIRST_INSTALL";
    private static final String PREF_PLAN = "PREF_PLAN";
    private static DataManager instance;
    private static SharedPreferences sharedPreferences;

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public static void init(Context context) {
        instance = new DataManager();
        instance.sharedPreferences = new SharedPreferences(context);
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public static void setFirstInstalled (boolean isFirst) {
        DataManager.getInstance().sharedPreferences.putBooleanValue(PREF_FIRST_INSTALL, isFirst);
    }

    public static boolean getFirstInstalled () {
        return DataManager.getInstance().sharedPreferences.getBooleanValue(PREF_FIRST_INSTALL);
    }

    public static void setPlan (Plan plan) {
        Gson gson = new Gson();
        String json = gson.toJson(plan);
        DataManager.getInstance().sharedPreferences.putStringValue(PREF_PLAN, json);
    }

    public static Plan getPlan () {
        Gson gson = new Gson();
        String json = DataManager.getInstance().sharedPreferences.getStringValue(PREF_PLAN);
        Plan plan = gson.fromJson(json, Plan.class);
        return plan;
    }
}
