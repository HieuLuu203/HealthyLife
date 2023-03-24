package com.example.healthylife.data;

import android.content.Context;

public class SharedPreferences {
    private static final String SHARED_PREFERENCES = "SHARED_PREFERENCES";
    private Context context;

    SharedPreferences(Context context) {
        this.context = context;
    }

    public void putBooleanValue (String key, boolean value) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBooleanValue (String key) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public void putStringValue(String key, String value) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getStringValue (String key) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }
}
