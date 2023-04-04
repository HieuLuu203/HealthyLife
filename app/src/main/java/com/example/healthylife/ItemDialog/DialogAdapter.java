package com.example.healthylife.ItemDialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthylife.Model.Plan;
import com.example.healthylife.Model.PlanManager;
import com.example.healthylife.R;

import java.util.ArrayList;
import java.util.List;

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.MyAdapter>{
    Context c;
    List<DialogModel> list, tmp;
    Plan plan;
    String meal;
    int size;

    public DialogAdapter(Context c)
    {
        this.c = c;
        tmp = new ArrayList<>();
    }

    public void setData(List<DialogModel>models, Plan plan, String meal)
    {
        this.list = models;
        this.plan = plan;
        this.meal = meal;
        for (DialogModel i : list)
        {
            i = plan.getFood(meal, i);
//            if (tmp == null)
//            {
//                i.setNumber(1);
//                i.setChecked(false);
//            }
//            else
//            {
//                i = tmp;
//                i.setChecked(true);
//            }

        }
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

        holder.up.setVisibility(View.INVISIBLE);
        holder.down.setVisibility(View.INVISIBLE);
        holder.number.setVisibility(View.INVISIBLE);
        holder.note.setVisibility(View.INVISIBLE);

        holder.foodName.setText(String.valueOf(model.getFoodName()));
        holder.number.setText(String.valueOf(model.getNumber()));
        holder.foodName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    holder.up.setVisibility(View.VISIBLE);
                    holder.down.setVisibility(View.VISIBLE);
                    holder.number.setVisibility(View.VISIBLE);
                    addList(model);
                }
                else{
                    holder.up.setVisibility(View.INVISIBLE);
                    holder.down.setVisibility(View.INVISIBLE);
                    holder.number.setVisibility(View.INVISIBLE);
                    removeList(model);
                }
            }
        });
        holder.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.increaseNumber();
                holder.number.setText(String.valueOf(model.getNumber()));
                set(model);
            }
        });

        holder.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.decreaseNumber();
                holder.number.setText(String.valueOf(model.getNumber()));
                set(model);
            }
        });

    }

    public void set (DialogModel m)
    {
        for (DialogModel i : tmp)
            if (i.getFoodName().equals(m.getFoodName()))
                i.setNumber(m.getNumber());
    }

    @Override
    public int getItemCount() {
            if(list == null) return 0;
            return list.size();
        }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView number, note;
        CheckBox foodName;

        Button ok,cancel;

        ImageButton up, down;
        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.item);
            up = itemView.findViewById(R.id.plus);
            down = itemView.findViewById(R.id.minus);
            number = itemView.findViewById(R.id.number);
            ok = itemView.findViewById(R.id.OKbtn);
            cancel = itemView.findViewById(R.id.Cancelbtn);
            note = itemView.findViewById(R.id.note);
        }
    }

    public void listClear(){
        tmp.clear();
    }

    public void addList(DialogModel model){
        tmp.add(model);
    }

    public List<DialogModel> getList(){
        return tmp;
    }

    public void removeList(DialogModel model){
        tmp.remove(model);
    }
}



