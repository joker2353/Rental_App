package com.malkinfo.rentalapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference ref;
    TextView Name,Email,Username,Password,profilename;
    ImageView Image;
    Button Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Name=findViewById(R.id.profileName);
        Email=findViewById(R.id.profileEmail);
        Username=findViewById(R.id.profileUsername);
        Password=findViewById(R.id.profilePassword);
        profilename=findViewById(R.id.titleUsername);
        Button=findViewById(R.id.editButton);
        Image = findViewById(R.id.profileImg);


        String uname= getIntent().getStringExtra("username");
        profilename.setText(uname);
        Glide.with(ProfileActivity.this)
                .load(R.drawable.baseline_account_circle_24)
                .centerCrop()
                .placeholder(R.drawable.baseline_account_circle_24)
                .into(Image);


        FirebaseDatabase.getInstance().getReference().child("users")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {


                            UserClass userClass = dataSnapshot.getValue(UserClass.class);
                            //Toast.makeText(ProfileActivity.this, userClass.username, Toast.LENGTH_SHORT).show();
                            if (userClass.username.equals(uname)) {
                                Name.setText(userClass.name);
                                Password.setText(userClass.password);
                                Username.setText(userClass.username);
                                Email.setText(userClass.email);
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ProfileActivity.this,UpdateProfile.class);

                intent.putExtra("username",uname );
                startActivity(intent);
            }
        });


    }
}