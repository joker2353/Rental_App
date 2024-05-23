package com.malkinfo.rentalapp;

import com.google.firebase.database.FirebaseDatabase;

/**
 * The Firebase class provides a singleton instance of the FirebaseDatabase.
 * It ensures that only one instance of FirebaseDatabase is created throughout the application.
 */
public class Firebase {
    private static FirebaseDatabase database;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * This enforces the singleton pattern.
     */
    private Firebase() {
    }

    /**
     * Gets the singleton instance of the FirebaseDatabase.
     * If the instance is not already initialized, it initializes it.
     *
     * @return The singleton instance of FirebaseDatabase.
     */
    public static FirebaseDatabase getFirebase() {
        if (database == null) {
            // Initialize FirebaseDatabase instance if it's not already initialized
            database = FirebaseDatabase.getInstance();
        }
        return database;
    }
}
