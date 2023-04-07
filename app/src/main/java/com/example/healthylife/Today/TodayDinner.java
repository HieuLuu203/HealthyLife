package com.example.healthylife.Today;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healthylife.MainActivity;
import com.example.healthylife.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.regex.*;

public class TodayDinner extends AppCompatActivity {

    static Calendar calendar = Calendar.getInstance();
    static int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

    RecyclerView recyclerView;
    TextView day;
    PlanAdapter adapter;
    ImageButton btn1;

    private String todayDate ()
    {
        switch (dayOfWeek)
        {
            case Calendar.SUNDAY:
                return "Sun";
            case Calendar.MONDAY:
                return "Mon";
            case Calendar.TUESDAY:
                return "Tue";
            case Calendar.WEDNESDAY:
                return "Wed";
            case Calendar.THURSDAY:
                return "Thu";
            case Calendar.FRIDAY:
                return "Fri";
            case Calendar.SATURDAY:
                return "Sat";
        }
        return null;
    }

    private String dayTitle ()
    {
        switch (dayOfWeek)
        {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_dinner);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.dinner);

        day = findViewById(R.id.day);
        day.setText(dayTitle());

        btn1 = findViewById(R.id.returnBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TodayDinner.this, MainActivity.class);
                startActivity(intent);
            }
        });

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