package com.malkinfo.rentalapp;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The sslcommerzActivity class represents the activity for processing payments using different methods.
 * It allows users to choose between credit card and mobile banking for payment processing.
 */
public class sslcommerzActivity extends AppCompatActivity {
    // UI elements
    RelativeLayout card, mb;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sslcommerz);

        // Initialize UI elements
        card = findViewById(R.id.card);
        mb = findViewById(R.id.mb);
        txt = findViewById(R.id.txt);

        // Initialize PaymentSystem
        PaymentSystem paymentSystem = new PaymentSystem();

        // Set up click listener for credit card payment
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set payment role to CreditCardProcessor
                paymentSystem.setPaymentRole(new CreditCardProcessor());
                // Process payment and display result
                txt.setText(paymentSystem.processPayment(100.0));
            }
        });

        // Set up click listener for mobile banking payment
        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set payment role to MobileBankingProcessor
                paymentSystem.setPaymentRole(new MobileBankingProcessor());
                // Process payment and display result
                txt.setText(paymentSystem.processPayment(50.0));
            }
        });
    }
}
