package com.example.healthylife.Today;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;

import com.example.healthylife.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.regex.*;

public class TodayDinner extends AppCompatActivity {

    ImageButton btn1;
    Button btn2;
    EditText text;
    public static Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_dinner);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.dinner);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.dinner:
                    return true;
                case R.id.lunch:
                    startActivity(new Intent(getApplicationContext(), TodayLunch.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return true;
                case R.id.breakfast:
                    startActivity(new Intent(getApplicationContext(), TodayBreakfast.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return true;
            }
            return false;
        });

    }

}