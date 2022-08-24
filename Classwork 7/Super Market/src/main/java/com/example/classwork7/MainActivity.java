package com.example.classwork7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Items> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Items cheese = new Items("Cheese", R.drawable.cheese,0.750);
        Items chocolate = new Items("Chocolate", R.drawable.chocolate,0.250);
        Items coffee = new Items("Coffee", R.drawable.coffee,2.000);
        Items donut = new Items("Donut", R.drawable.donut,0.500);
        Items fries = new Items("Fries", R.drawable.fries,1.000);
        Items honey = new Items("Honey" , R.drawable.honey,5.000);

        items.add(cheese);
        items.add(chocolate);
        items.add(coffee);
        items.add(donut);
        items.add(fries);
        items.add(honey);

        ListView itemsListJava = findViewById(R.id.listViewItems);
        Adapter ad = new Adapter(this,0,items);
        itemsListJava.setAdapter(ad);


        itemsListJava.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Items currentProduct = ad.getItem(i);

                Intent detail = new Intent( MainActivity.this, DetailsActivity.class);

                detail.putExtra("product", currentProduct);
                startActivity(detail);

            }
        });







    }

}