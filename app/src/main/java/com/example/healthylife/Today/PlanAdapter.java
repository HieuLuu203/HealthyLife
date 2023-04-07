package com.example.healthylife.Today;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.healthylife.ItemDialog.DialogBox;

import com.example.healthylife.ItemDialog.DialogBox;
import com.example.healthylife.ItemDialog.DialogModel;
import com.example.healthylife.Model.Plan;
import com.example.healthylife.Model.PlanManager;
import com.example.healthylife.R;

import java.util.ArrayList;
import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.MyAdapter>{
    Context c;
    List<DialogModel> list = new ArrayList<>();

    int size;

    public  PlanAdapter () {}
    public PlanAdapter(Context c) {
        this.c = c;
    }
    public void setData(List<DialogModel> models){
        this.list = models;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlanAdapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_layout, parent, false);
        return new MyAdapter(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanAdapter.MyAdapter holder, int position) {
        if (list.equals(null)) return;
        DialogModel model = list.get(position);
        holder.number.setText(String.valueOf(model.getNumber()*100) + "g");
        holder.calories.setText(String.valueOf(model.getFoodCalories()) + "kcal");
        holder.foodName.setText(model.getFoodName());
        holder.foodImage.setImageResource(model.getFoodImage());
    }

    @Override
    public int getItemCount() {
        if(list == null) return 0;
        return list.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView number, calories, foodName, day;
        ImageView foodImage;
        CheckBox checkBox;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            calories = itemView.findViewById(R.id.calories);
            foodImage = itemView.findViewById(R.id.foodImage);
            foodName = itemView.findViewById(R.id.foodName);
            checkBox = itemView.findViewById(R.id.consumed);
        }
    }
}




