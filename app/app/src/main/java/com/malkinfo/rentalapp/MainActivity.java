package com.malkinfo.rentalapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The MainActivity class represents the main screen of the application.
 * It allows users to navigate to different sections such as homes and cars.
 */
public class MainActivity extends AppCompatActivity {

    private RelativeLayout home, car;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        home = findViewById(R.id.homeAct);
        car = findViewById(R.id.carAct);

        // Get the username passed from the previous activity
        String uname = getIntent().getStringExtra("username");

        // Set OnClickListener for the home section
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the HomesActivity
                Intent intent = new Intent(MainActivity.this, HomesActivity.class);
                intent.putExtra("username", uname); // Pass the username to the next activity
                startActivity(intent);
            }
        });

        // Set OnClickListener for the car section
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the CarsActivity
                Intent intent = new Intent(MainActivity.this, CarsActivity.class);
                startActivity(intent);
            }
        });
    }
}
