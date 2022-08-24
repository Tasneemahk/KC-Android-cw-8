package com.example.classwork7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ImageView picture = findViewById(R.id.picture);
        TextView item = findViewById(R.id.item);

        Bundle bundle = getIntent().getExtras();
        Items product1 = (Items) bundle.getSerializable("product");
        item.setText(product1.getItemName());
        picture.setImageResource(product1.getItemImage());



    }
}