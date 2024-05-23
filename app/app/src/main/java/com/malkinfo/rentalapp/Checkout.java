package com.malkinfo.rentalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The Checkout class represents the checkout screen in the RentalApp.
 * Users can choose between different payment methods such as PayPal and SSLCommerz.
 */
public class Checkout extends AppCompatActivity {

    private RelativeLayout paypal;
    private RelativeLayout ssl;

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
        setContentView(R.layout.activity_checkout);

        // Initialize UI elements
        paypal = findViewById(R.id.paypal);
        ssl = findViewById(R.id.ssl);

        // Set click listener for PayPal payment method
        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkout.this, Payment.class);
                startActivity(intent);
            }
        });

        // Set click listener for SSLCommerz payment method
        ssl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkout.this, sslcommerzActivity.class);
                startActivity(intent);
            }
        });
    }
}
