package com.example.healthylife.Home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.healthylife.ItemDialog.DialogBox;

import com.example.healthylife.ItemDialog.DialogBox;
import com.example.healthylife.ItemDialog.DialogModel;
import com.example.healthylife.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyAdapter>{
    Context c;
    List<Model> list;
    List <DialogModel> dialogList;
    int size;

    public  Adapter () {
        dialogList.add(new DialogModel("Apple"));
        dialogList.add(new DialogModel("Banana"));
        dialogList.add(new DialogModel("Orange"));
        dialogList.add(new DialogModel("Milk"));
        dialogList.add(new DialogModel("Egg"));
        dialogList.add(new DialogModel("Rice"));
        dialogList.add(new DialogModel("Beef"));
        dialogList.add(new DialogModel("Chicken"));
        dialogList.add(new DialogModel("Fish"));
        dialogList.add(new DialogModel("Pork"));
    }
    public Adapter(Context c) {
        this.c = c;

    }
    public void setData(List<Model>models){
        this.list = models;
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
                DialogFragment dialogBox = new DialogBox();
                dialogBox.show(((HomeActivity) c).getSupportFragmentManager(), "Dialog Box");

//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
//                View dialogView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.dialog_item, null);
//                builder.setMultiChoiceItems(R.array.food, null, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                        if (isChecked) {
//                            AlertDialog.Builder amountDialog = new AlertDialog.Builder(view.getRootView().getContext());
//                            View amountView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.dialog_number, null);
//                            amountDialog.setView(amountView);
//                            amountDialog.show();
//                        } else {
//                            // Else, if the item is already in the array, remove it
//                            Toast.makeText(c, "Unchecked", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//                builder.setView(dialogView);
//                builder.show();

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



