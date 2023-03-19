package com.example.healthylife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyAdapter>{
    Context c;
    List<Model> list;
    int size;

    public Adapter(Context c, List<Model> list, int size) {
        this.c = c;
        this.list = list;
        this.size = size;
    }

    @NonNull
    @Override
    public Adapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyAdapter(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyAdapter holder, int position) {
        Model model = list.get(position);
        holder.day.setText(model.getDay());
        holder.BBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new FragmentDialogBox().show(getSupportFragmentManager(), "Dialog Box");
                Toast.makeText(c, "Success" , Toast.LENGTH_SHORT).show();
            }
        });

        holder.DBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c, "Success" , Toast.LENGTH_SHORT).show();
            }
        });

        holder.LBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c, "Success" , Toast.LENGTH_SHORT).show();
            }
        });

        holder.SBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c, "Success" , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView day;
        ImageButton BBtn, LBtn, DBtn, SBtn;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            BBtn = itemView.findViewById(R.id.addB);
            LBtn = itemView.findViewById(R.id.addL);
            DBtn = itemView.findViewById(R.id.addD);
            SBtn = itemView.findViewById(R.id.addS);
        }
    }
}
