package com.malkinfo.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView price, shortDescription, description;
    String pri, des, shdes, img,selectedHouseType;
    AutoCompleteTextView autoCompleteTextView;
    Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String[] languages = getResources().getStringArray(R.array.programming_languages);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.dropdown_item, languages);

        AutoCompleteTextView autocompleteTV = findViewById(R.id.autoCompleteTextView);

        autocompleteTV.setAdapter(arrayAdapter);

        autocompleteTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 selectedHouseType = parent.getItemAtPosition(position).toString();
            }
        });


//        String[] language = getResources().getStringArray(R.array.prog);
//
//        ArrayAdapter<String> arrayAdapte = new ArrayAdapter<>(this, R.layout.dropdown_item, language);
//
//        AutoCompleteTextView autocompleteT = findViewById(R.id.autoCompleteTextViews);
//
//        autocompleteT.setAdapter(arrayAdapter);

        RoomType r=new AcRoom(selectedHouseType);
        Apartment a=new Apartment(r);





        imageView = findViewById(R.id.imageView);
        price = findViewById(R.id.price);
        shortDescription = findViewById(R.id.short_description);
        description = findViewById(R.id.description);
        apply=findViewById(R.id.applying);

        pri = getIntent().getStringExtra("price");
        des = getIntent().getStringExtra("description");
        shdes = getIntent().getStringExtra("shortDescription");
        img = getIntent().getStringExtra("image");
       // Toast.makeText(this, pri, Toast.LENGTH_SHORT).show();


        price.setText( pri);
        description.setText(des);
        shortDescription.setText(shdes);

        Glide.with(this)

                .load(img)
                .centerCrop()
                .placeholder(R.drawable.baseline_account_circle_24)
                .into(imageView);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, Checkout.class);
                Toast.makeText(DetailsActivity.this, selectedHouseType, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

}