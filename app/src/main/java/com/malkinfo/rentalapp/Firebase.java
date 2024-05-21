package com.malkinfo.rentalapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase {
    private static FirebaseDatabase database;
    private static DatabaseReference reference;

    // Private constructor to prevent instantiation from outside
    private Firebase() {
    }

    // Method to get a reference to the FirebaseDatabase instance
    public static DatabaseReference getFirebase() {
        if (database == null) {
            // Initialize FirebaseDatabase instance if it's not already initialized
            database = FirebaseDatabase.getInstance();
            // Get reference to the "users" node
            reference = database.getReference("users");
        }
        return reference;
    }

}
