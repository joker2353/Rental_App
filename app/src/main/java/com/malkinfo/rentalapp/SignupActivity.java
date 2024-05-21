package com.malkinfo.rentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class SignupActivity extends AppCompatActivity {

    EditText signupName,signupEmail,signupUsername,signupPassword;
    TextView loginRedirectText;
    Button signupButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName=findViewById(R.id.signup_name);
        signupEmail=findViewById(R.id.signup_email);
        signupUsername=findViewById(R.id.signup_username);
        signupPassword=findViewById(R.id.signup_password);
        loginRedirectText=findViewById(R.id.loginRedirectText);
        signupButton=findViewById(R.id.signup_button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String name=signupName.getText().toString();
                 String email=signupEmail.getText().toString();
                 String username=signupUsername.getText().toString();
                 String password=signupPassword.getText().toString();


                UserClass userClass=new UserClass(name,email,username,password);
                DatabaseReference firebaseref=Firebase.getFirebase();
                firebaseref.child(username).setValue(userClass);


                Toast.makeText(SignupActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }


        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}