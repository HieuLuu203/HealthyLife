package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.healthylife.ItemDialog.DialogModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Model> list = new ArrayList<>();
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addData();
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new Adapter(this);
        adapter.setData(list);
        recyclerView.setAdapter(adapter);
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