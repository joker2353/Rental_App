package com.malkinfo.rentalapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The Feature class represents an activity in the RentalApp where users can select a feature
 * from a list of available features using an AutoCompleteTextView.
 */
public class Feature extends AppCompatActivity {

    private static final String[] items = {"Sunroof", "GPS", "Music System"};

    private AutoCompleteTextView autoCompleteTextView;
    private ArrayAdapter<String> adapterItems;

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
        setContentView(R.layout.activity_feature);

        // Initialize the AutoCompleteTextView and its adapter
        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<>(this, R.layout.list_item, items);

        // Set the adapter to the AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapterItems);

        // Set item click listener for AutoCompleteTextView
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Feature.this, item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
