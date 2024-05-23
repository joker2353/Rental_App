package com.malkinfo.rentalapp;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserControl {
    public UserControl() {
    }

    public UserClass appUser;
    public UserClass getuser(){
        if(appUser==null){
            FirebaseDatabase.getInstance().getReference().child("users")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {


                                UserClass userClass = dataSnapshot.getValue(UserClass.class);
                                //Toast.makeText(ProfileActivity.this, userClass.username, Toast.LENGTH_SHORT).show();
//                                if (userClass.username.equals("rai")) {
//                                    appUser.setName(userClass.name);
//                                    appUser.setPassword(userClass.password);
//                                    appUser.setUsername(userClass.username);
//                                    appUser.setEmail(userClass.email);
//                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        }
        return appUser;
    }

    //public static void setUser(String userName) {
//        if(appUser == null ){
//            //TreeFactory treeFactory = new TreeFactory();
//            //DatabaseReference firebaseref=treeFactory.getFirebaseTree("users");
//            firebaseref.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                        UserClass userClass = dataSnapshot.getValue(UserClass.class);
//                        //Toast.makeText(ProfileActivity.this, userClass.username, Toast.LENGTH_SHORT).show();
//                        if (userClass.username.equals(userName)) {
//                            appUser=userClass;
//                        }
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
//
//
//
//        }
//
//    }
//
//    public static UserClass getUser(String userName) {
//        if(appUser == null || !userName.equals(appUser.getUsername()))
//        {
//            setU(userName);
//        }
//        return appUser;
//    }
}
