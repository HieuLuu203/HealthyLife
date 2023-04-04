package com.example.healthylife.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.healthylife.MainActivity;
import com.example.healthylife.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Model> list = new ArrayList<>();
    Adapter adapter;

    ImageButton btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addData();
        setContentView(R.layout.activity_home);
        btn1 = findViewById(R.id.returnBtn);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new Adapter(this);
        adapter.setData(list);
        recyclerView.setAdapter(adapter);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addData() {
        list.add(new Model("Mon"));
        list.add(new Model("Tue"));
        list.add(new Model("Wed"));
        list.add(new Model("Thu"));
        list.add(new Model("Fr i"));
        list.add(new Model("Sat"));
        list.add(new Model("Sun"));
    }
}