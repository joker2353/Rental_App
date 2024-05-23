package com.malkinfo.rentalapp;

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

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

/**
 * The DetailsActivity class displays detailed information about a selected rental property.
 * Users can view property details such as price, description, and image, and select a room type
 * before proceeding to the checkout.
 */
public class DetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView price, shortDescription, description;
    private String pri, des, shdes, img, selectedHouseType;
    private AutoCompleteTextView autoCompleteTextView;
    private Button apply;

    /**
     * Called when the activity is starting. This is where most initialization should go:
     * calling setContentView(int) to inflate the activity's UI, using findViewById(int) to programmatically interact with widgets in the UI, etc.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     *                           Note: Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Initialize UI elements
        imageView = findViewById(R.id.imageView);
        price = findViewById(R.id.price);
        shortDescription = findViewById(R.id.short_description);
        description = findViewById(R.id.description);
        apply = findViewById(R.id.applying);

        // Get data from intent
        pri = getIntent().getStringExtra("price");
        des = getIntent().getStringExtra("description");
        shdes = getIntent().getStringExtra("shortDescription");
        img = getIntent().getStringExtra("image");

        // Set data to UI elements
        price.setText(pri);
        description.setText(des);
        shortDescription.setText(shdes);

        // Load image using Glide
        Glide.with(this)
                .load(img)
                .centerCrop()
                .placeholder(R.drawable.baseline_account_circle_24)
                .into(imageView);

        // Initialize the AutoCompleteTextView for room types
        String[] languages = getResources().getStringArray(R.array.RoomType);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.dropdown_item, languages);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(arrayAdapter);

        // Set item click listener for AutoCompleteTextView
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedHouseType = parent.getItemAtPosition(position).toString();
            }
        });

        // Set click listener for Apply button
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
