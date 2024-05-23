package com.malkinfo.rentalapp;


import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;



public class UserProxy {
    public UserProxy() {
    }

    private UserClass appUser;
    private DatabaseReference firebaseref;


    // Your existing code

    public UserClass getAppUser(String uname){

        FirebaseDatabase.getInstance().getReference().child("users")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {


                            UserClass userClass = dataSnapshot.getValue(UserClass.class);
                            //Toast.makeText(ProfileActivity.this, userClass.username, Toast.LENGTH_SHORT).show();
                            if(userClass ==null){
//                                Name.setText("nul");
//                                Password.setText("nul");
//                                Username.setText("nul");
//                                Email.setText("nul");
                            }else {


                                if (userClass.getUsername().equals("rai")) {
                                    appUser=userClass;
//                                    appUser.setName(userClass.getName());
//                                    appUser.setUsername(userClass.getUsername());
//                                    appUser.setEmail(userClass.getEmail());
//                                    appUser.setPassword(userClass.getPassword());

//                                    Name.setText(userClass.getName());
//                                    Password.setText(userClass.getPassword());
//                                    Username.setText(userClass.getUsername());
//                                    Email.setText(userClass.getEmail());
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


        return appUser;
    }
    public void checkUser() {
        String userUsername = "rai";
        String userPassword = "rai";
        TreeFactory treeFactory = new TreeFactory();
        firebaseref = treeFactory.getFirebaseTree("users");

        Query checkUserDatabase = firebaseref.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    UserClass user = snapshot.getValue(UserClass.class); // Retrieve UserClass object directly from snapshot
                    if (user != null && user.getPassword().equals(userPassword)) {

                        // Store the retrieved UserClass object in the global variable appUser
                        appUser = user;

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
            }
        });
    }
    public UserClass getUser(){
        checkUser();
        return appUser;
    }


}

