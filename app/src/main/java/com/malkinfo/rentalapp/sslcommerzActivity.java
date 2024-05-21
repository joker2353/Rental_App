package com.malkinfo.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class sslcommerzActivity extends AppCompatActivity {
    RelativeLayout card,mb;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sslcommerz);
        card=findViewById(R.id.card);
        mb=findViewById(R.id.mb);
        txt=findViewById(R.id.txt);
        PaymentSystem paymentSystem = new PaymentSystem();

        // Using Credit Card Processor



        // Using PayPal Processor



        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentSystem.setPaymentRole(new CreditCardProcessor());
               txt.setText(paymentSystem.processPayment(100.0));
            }
        });

        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentSystem.setPaymentRole(new MobileBankingProcessor());
                txt.setText( paymentSystem.processPayment(50.0));
            }
        });



    }
}