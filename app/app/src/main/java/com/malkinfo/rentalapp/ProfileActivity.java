package com.malkinfo.rentalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
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

//ProxyUser up =new ProxyUser();
//UserClass u = up.getAppUser();
//        if( u == null) {


//UserProxy1 up=new UserProxy1();
//UserClass u=up.getAppUserSync(uname);
//
//if( u ==null) {
//    Name.setText("u.getName()");
//    Password.setText("u.getPassword()");
//    Username.setText("u.getUsername()");
//    Email.setText("u.getEmail()");
//}else{
//    Name.setText(u.getName());
//    Password.setText(u.getPassword());
//    Username.setText(u.getUsername());
//    Email.setText(u.getEmail());
//}
//        if( up ==null) {
//            Name.setText("nai");
//        }else{
//            Name.setText("haiii");
//        }
//

            FirebaseDatabase.getInstance().getReference().child("users")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {


                                UserClass userClass = dataSnapshot.getValue(UserClass.class);
                                //Toast.makeText(ProfileActivity.this, userClass.username, Toast.LENGTH_SHORT).show();
                                if (userClass == null) {
                                    Name.setText("nul");
                                    Password.setText("nul");
                                    Username.setText("nul");
                                    Email.setText("nul");
                                } else {

                                    if (userClass.getUsername().equals(uname)) {
                                        Name.setText(userClass.getName());
                                        Password.setText(userClass.getPassword());
                                        Username.setText(userClass.getUsername());
                                        Email.setText(userClass.getEmail());
                                    }
                                    //                                   Name.setText("ok");
//                                   Password.setText("ok");
//                                    Username.setText("ok");
//                                    Email.setText("ok");

                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

//            String name = Name.getText().toString().trim();
//            String password = Password.getText().toString().trim();
//            String username = Username.getText().toString().trim();
//            String email = Email.getText().toString().trim();
//
//            up.setAppUser(name,username,email,password);


//            p.appUser.setName(name);
//            p.appUser.setUsername(username);
//            p.appUser.setEmail(email);
//            p.appUser.setPassword(password);

//        }else {
//
//            Name.setText(u.getName());
//            Password.setText(u.getPassword());
//            Username.setText(u.getUsername());
//            Email.setText(u.getEmail());
//
//        }

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