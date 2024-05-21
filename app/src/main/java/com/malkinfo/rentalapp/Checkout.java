package com.malkinfo.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Checkout extends AppCompatActivity {


    RelativeLayout paypal,ssl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        paypal=findViewById(R.id.paypal);
        ssl=findViewById(R.id.ssl);

//        Intent intent= new Intent(this,SignupActivity.class);
//        startActivity(intent);

        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Checkout.this,Payment.class);
                startActivity(intent);
            }
        });

        ssl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Checkout.this,sslcommerzActivity.class);
                startActivity(intent);
            }
        });


    }
}