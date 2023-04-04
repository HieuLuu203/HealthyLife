package com.example.healthylife.Home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.healthylife.ItemDialog.DialogBox;

import com.example.healthylife.ItemDialog.DialogBox;
import com.example.healthylife.ItemDialog.DialogModel;
import com.example.healthylife.Model.PlanManager;
import com.example.healthylife.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyAdapter>{
    Context c;
    List<Model> list;
    PlanManager planManager = PlanManager.getInstance();
    int size;

    public  Adapter () {}
    public Adapter(Context c) {
        this.c = c;

    }
    public void setData(List<Model>models){
        this.list = models;
        notifyDataSetChanged();
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
                DialogBox dialogBox = new DialogBox();
                dialogBox.setData(planManager.getPlan(model.getDay()), "breakfast");
                dialogBox.show(((HomeActivity) c).getSupportFragmentManager(), "Dialog Box");
//                List<DialogModel> test = planManager.getPlan("Mon").getBreakfast();
//                for (DialogModel i : test)
//                    System.out.println(i.getFoodName());
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
    }

    @Override
    public int getItemCount() {
        if(list == null) return 0;
        return list.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView day;
        ImageButton BBtn, LBtn, DBtn;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            BBtn = itemView.findViewById(R.id.addB);
            LBtn = itemView.findViewById(R.id.addL);
            DBtn = itemView.findViewById(R.id.addD);
        }
    }
}




