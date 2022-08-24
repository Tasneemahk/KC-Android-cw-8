package com.example.classwork7;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Adapter extends ArrayAdapter<Items> {

    List<Items> itemsListOver;


    public Adapter(@NonNull Context context, int resource, @NonNull List<Items> objects) {
        super(context, resource, objects);
        itemsListOver = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        Items currentItem = itemsListOver.get(position);

        TextView name = view.findViewById(R.id.nameItem);
        TextView price= view.findViewById(R.id.priceInput);
        ImageView IMG = view.findViewById(R.id.imageView);

        name.setText(currentItem.getItemName());
        price.setText(String.valueOf(currentItem.getItemPrice()));
        IMG.setImageResource(currentItem.getItemImage());


        ImageView delete = view.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                builder1.setMessage("Are you sure you want to delete this item?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder1.create();
                alert.show();
                remove(currentItem);
                notifyDataSetChanged();
                

            }



            });
        return view;
        }









    }



