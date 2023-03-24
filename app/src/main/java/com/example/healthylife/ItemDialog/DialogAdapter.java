package com.example.healthylife.ItemDialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthylife.R;

import java.util.List;

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.MyAdapter>{
    Context c;
    List<DialogModel> list;
    int size;

    public DialogAdapter(Context c) {
        this.c = c;
    }

    public void setData(List<DialogModel>models)
    {
        this.list = models;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DialogAdapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_item, parent, false);
        return new MyAdapter(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogAdapter.MyAdapter holder, int position) {
        DialogModel model = list.get(position);
        if(model == null){
            return;
        }
        holder.foodName.setText(model.getFoodName());
        holder.number.setText(model.getNumber() + "");
        holder.foodName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.increaseNumber();
            }
        });

        holder.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.decreaseNumber();
            }
        });


    }

    @Override
    public int getItemCount() {
            if(list == null) return 0;
            return list.size();
        }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView number;
        CheckBox foodName;

        ImageButton up, down;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.item);
            up = itemView.findViewById(R.id.plus);
            down = itemView.findViewById(R.id.minus);

        }
    }
}



