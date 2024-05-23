package com.malkinfo.rentalapp;


import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProxy1 {
    private UserClass appUser;
    private DatabaseReference firebaseref;

    public UserProxy1() {
        firebaseref = FirebaseDatabase.getInstance().getReference().child("users");
    }

    public void getAppUser(String uname, UserCallback callback) {
        firebaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserClass userClass = dataSnapshot.getValue(UserClass.class);
                    if (userClass != null && userClass.getUsername().equals(uname)) {
                        appUser = userClass;
                        callback.onUserReceived(appUser);
                        return; // Exit loop once user is found
                    }
                }
                // If user is not found
                callback.onUserNotFound();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
                callback.onCancelled(error);
            }
        });
    }

    public interface UserCallback {
        void onUserReceived(UserClass user);
        void onUserNotFound();
        void onCancelled(DatabaseError error);
    }

    public UserClass getAppUserSync(String uname) {
        getAppUser(uname, new UserCallback() {
            @Override
            public void onUserReceived(UserClass user) {
                // Do nothing, appUser is set in getAppUser method
            }

            @Override
            public void onUserNotFound() {
                // User not found
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle database error
            }
        });
        return appUser;
    }
}
