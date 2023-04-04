package com.example.healthylife.ItemDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthylife.Model.Plan;
import com.example.healthylife.Model.PlanManager;
import com.example.healthylife.R;

import java.util.ArrayList;
import java.util.List;

public class DialogBox extends DialogFragment {
    private static final String TAG = "DialogBox";
    RecyclerView recyclerView;
    List<DialogModel> dialogList = new ArrayList<>();
    Plan plan;
    String meal;
    DialogAdapter adapter;

    private TextView cancelBtn, okBtn;

    public void setData(Plan plan, String meal)
    {
        this.plan = plan;
        System.out.println(plan.getDay());
        this.meal = meal;
    }

    public DialogBox() {
        dialogList.add(new DialogModel("Chicken"));
        dialogList.add(new DialogModel("Apple"));
        dialogList.add(new DialogModel("Banana"));
        dialogList.add(new DialogModel("Orange"));
        dialogList.add(new DialogModel("Milk"));
        dialogList.add(new DialogModel("Egg"));
        dialogList.add(new DialogModel("Rice"));
        dialogList.add(new DialogModel("Beef"));
        dialogList.add(new DialogModel("Fish"));
        dialogList.add(new DialogModel("Pork"));
        dialogList.add(new DialogModel("Pasta"));
        dialogList.add(new DialogModel("Bread"));
        dialogList.add(new DialogModel("Potato"));
        dialogList.add(new DialogModel("Tomato"));
        dialogList.add(new DialogModel("Cucumber"));
        dialogList.add(new DialogModel("Carrot"));
        dialogList.add(new DialogModel("Spinach"));
        dialogList.add(new DialogModel("Cabage"));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate layout with recycler view
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.custom_dialog, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.dialogRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), RecyclerView.VERTICAL, false));
        //setadapter
        DialogAdapter adapter = new DialogAdapter(this.getActivity());
        adapter.setData(dialogList, plan, meal);
        recyclerView.setAdapter(adapter);

        okBtn = v.findViewById(R.id.OKbtn);
        cancelBtn = v.findViewById(R.id.Cancelbtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.listClear();
                getDialog().dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < adapter.getList().size(); i++)
                {
                    System.out.println(adapter.getList().get(i).getNumber());
                }
                plan.setMeal(adapter.getList(), meal);
                PlanManager.getInstance().setPlan(getPlan(), "Mon");
                adapter.listClear();
                getDialog().dismiss();
            }
        });

        return v;
    }

    public Plan getPlan() {return this.plan;}

//    public void update ()
//    {
//        DialogAdapter adapter = new DialogAdapter(this.getActivity());
//        adapter.setData(dialogList, plan, meal);
//        recyclerView.setAdapter(adapter);
//    }

//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        super.onCreateDialog(savedInstanceState);
////        View view = LayoutInflater.from(getActivity()).inflate(R.layout.custom_dialog, null);
////        recyclerView = view.findViewById(R.id.dialogRecyclerView);
////        adapter = new DialogAdapter(getContext());
////        recyclerView.setAdapter(adapter);
////        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
////        recyclerView.setLayoutManager(linearLayoutManager);
////        adapter.setData(dialogList);
//
//        return new AlertDialog.Builder(getActivity())
//                .setTitle("Choose food")
//                .setPositiveButton(android.R.string.ok,
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int whichButton) {
//                                // do something
//                                Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
//                        }
//                })
//                .setNegativeButton(android.R.string.cancel,
//                        new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        // do something
//                        Toast.makeText(getContext(), "Cancel", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                }

}

