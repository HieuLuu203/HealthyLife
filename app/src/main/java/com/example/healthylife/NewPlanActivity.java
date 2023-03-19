package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.EditText;
import java.util.regex.*;

public class NewPlanActivity extends AppCompatActivity {

    ImageButton btn1;
    Button btn2;
    EditText text;
    public static Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);
        btn1 = findViewById(R.id.imageButton);
        btn2 = findViewById(R.id.button2);
        text = findViewById(R.id.PersonName);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = text.getText().toString();
                if (validName(name) == true) {
                    Toast.makeText(getApplicationContext(), "Welcome " + name, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid name: " + name, Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPlanActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public static boolean validName(String name) {
        Matcher matcher = namePattern.matcher(name);
        return matcher.matches();
    }

}