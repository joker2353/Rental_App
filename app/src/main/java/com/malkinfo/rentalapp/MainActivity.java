package com.malkinfo.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout home,car;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home=findViewById(R.id.homeAct);
        car=findViewById(R.id.carAct);
//        Intent intent= new Intent(this,SignupActivity.class);
//        startnotActivity(intent);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,HomesActivity.class);
                startActivity(intent);
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,CarsActivity.class);
                startActivity(intent);
            }
        });

    }

}