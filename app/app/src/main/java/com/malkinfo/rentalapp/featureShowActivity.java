package com.malkinfo.rentalapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The featureShowActivity class represents an activity in the RentalApp that displays
 * the selected features of a rental property.
 */
public class featureShowActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_feature_show);
    }
}
