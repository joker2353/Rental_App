package com.malkinfo.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class Feature extends AppCompatActivity {

    String[] item={"Sunroof","GPS","Music System"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature);

        autoCompleteTextView=findViewById(R.id.auto_complete_txt);
        adapterItems= new ArrayAdapter<String>(this,R.layout.list_item,item);


        autoCompleteTextView.setAdapter(adapterItems);
        
       autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String item=adapterView.getItemAtPosition(i).toString();
               Toast.makeText(Feature.this, "Item", Toast.LENGTH_SHORT).show();
           }
       });



    }
}