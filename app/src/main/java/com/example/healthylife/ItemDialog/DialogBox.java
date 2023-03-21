package com.example.healthylife.ItemDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthylife.R;

import java.util.ArrayList;
import java.util.List;

public class DialogBox extends DialogFragment {
    RecyclerView recyclerView;
    List<DialogModel> dialogList = new ArrayList<>();
    DialogAdapter adapter;

    public DialogBox() {
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
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        //inflate layout with recycler view
//        View v = inflater.inflate(R.layout.custom_dialog, container, false);
//        recyclerView = (RecyclerView) v.findViewById(R.id.dialogRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        //setadapter
//        DialogAdapter adapter = new DialogAdapter(getContext());
//        recyclerView.setAdapter(adapter);
//        //get your recycler view and populate it.
//        return v;
//    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.custom_dialog, null);
//        recyclerView = view.findViewById(R.id.dialogRecyclerView);
//        adapter = new DialogAdapter(getContext());
//        recyclerView.setAdapter(adapter);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        adapter.setData(dialogList);
//        System.out.println("2");

        return new AlertDialog.Builder(getActivity())
                .setMultiChoiceItems(R.array.food, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            Toast.makeText(getContext(), "Checked", Toast.LENGTH_SHORT).show();
                        } else {
                            // Else, if the item is already in the array, remove it
                            Toast.makeText(getContext(), "Unchecked", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setTitle("Choose food")
                //.setView(recyclerView)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // do something
                                System.out.println(dialogList.size());
                            }
                        }
                ).create();
    }



}

