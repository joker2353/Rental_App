package com.malkinfo.rentalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * The UpdateProfile class allows users to update their profile information.
 * It retrieves the user's current information and provides fields to modify the name, email, username, and password.
 * Upon clicking the update button, the new information is stored in the Firebase Realtime Database.
 */
public class UpdateProfile extends AppCompatActivity {

    DatabaseReference ref;
    EditText Name, Email, Username, Password;
    TextView profilename;
    ImageView Image;
    android.widget.Button Button;
    String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        // Initialize UI elements
        Name = findViewById(R.id.profileName);
        Email = findViewById(R.id.profileEmail);
        Username = findViewById(R.id.profileUsername);
        Password = findViewById(R.id.profilePassword);
        profilename = findViewById(R.id.titleUsername);
        Button = findViewById(R.id.editButton);
        Image = findViewById(R.id.profileImg);

        // Get username from intent
        uname = getIntent().getStringExtra("username");
        profilename.setText(uname);

        // Load default profile image
        Glide.with(UpdateProfile.this)
                .load(R.drawable.baseline_account_circle_24)
                .centerCrop()
                .placeholder(R.drawable.baseline_account_circle_24)
                .into(Image);

        // Get reference to Firebase
        ref = FirebaseDatabase.getInstance().getReference().child("users").child(uname);

        // Set up click listener for update button
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get updated user information
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String username = Username.getText().toString();
                String password = Password.getText().toString();

                // Create user object with updated information
                UserClass userClass = new UserClass(name, email, username, password);

                // Store updated information in Firebase
                ref.setValue(userClass);

                // Redirect to profile activity
                Intent intent = new Intent(UpdateProfile.this, ProfileActivity.class);
                intent.putExtra("username", uname);
                startActivity(intent);
            }
        });
    }
}
