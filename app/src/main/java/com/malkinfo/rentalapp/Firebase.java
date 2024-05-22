package com.malkinfo.rentalapp;

import com.google.firebase.database.FirebaseDatabase;

public class Firebase {
    private static FirebaseDatabase database;
    // Private constructor to prevent instantiation from outside
    private Firebase() {
    }
    // Method to get a reference to the FirebaseDatabase instance
    public static FirebaseDatabase getFirebase() {
        if (database == null) {
            // Initialize FirebaseDatabase instance if it's not already initialized
            database = FirebaseDatabase.getInstance();
        }
        return database;
    }

}
