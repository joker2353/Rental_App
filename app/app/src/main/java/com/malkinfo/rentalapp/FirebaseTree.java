package com.malkinfo.rentalapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * FirebaseTree interface defines a method to get a DatabaseReference from Firebase.
 */
public interface FirebaseTree {
    /**
     * Gets the DatabaseReference for a specific Firebase tree.
     *
     * @return DatabaseReference for the specific Firebase tree.
     */
    DatabaseReference getFirebase();
}

/**
 * HomesTree class implements FirebaseTree to provide a reference to the "homes" tree in Firebase.
 */
class HomesTree implements FirebaseTree {
    private FirebaseDatabase database;
    private DatabaseReference reference;

    /**
     * Constructor initializes the FirebaseDatabase instance.
     */
    public HomesTree() {
        database = Firebase.getFirebase();
    }

    /**
     * Gets the DatabaseReference for the "homes" tree.
     *
     * @return DatabaseReference for the "homes" tree.
     */
    @Override
    public DatabaseReference getFirebase() {
        reference = database.getReference("homes");
        return reference;
    }
}

/**
 * OrdersTree class implements FirebaseTree to provide a reference to the "orders" tree in Firebase.
 */
class OrdersTree implements FirebaseTree {
    private FirebaseDatabase database;
    private DatabaseReference reference;

    /**
     * Constructor initializes the FirebaseDatabase instance.
     */
    public OrdersTree() {
        database = Firebase.getFirebase();
    }

    /**
     * Gets the DatabaseReference for the "orders" tree.
     *
     * @return DatabaseReference for the "orders" tree.
     */
    @Override
    public DatabaseReference getFirebase() {
        reference = database.getReference("orders");
        return reference;
    }
}

/**
 * UsersTree class implements FirebaseTree to provide a reference to the "users" tree in Firebase.
 */
class UsersTree implements FirebaseTree {
    private FirebaseDatabase database;
    private DatabaseReference reference;

    /**
     * Constructor initializes the FirebaseDatabase instance.
     */
    public UsersTree() {
        database = Firebase.getFirebase();
    }

    /**
     * Gets the DatabaseReference for the "users" tree.
     *
     * @return DatabaseReference for the "users" tree.
     */
    @Override
    public DatabaseReference getFirebase() {
        reference = database.getReference("users");
        return reference;
    }
}

/**
 * TreeFactory class provides a method to get a specific Firebase tree based on the provided type.
 */
class TreeFactory {
    private FirebaseTree firebaseTree;

    /**
     * Gets the DatabaseReference for a specific Firebase tree based on the tree type.
     *
     * @param treeType The type of the tree (e.g., "users", "homes").
     * @return DatabaseReference for the specified tree type, or null if the type is not recognized.
     */
    public DatabaseReference getFirebaseTree(String treeType) {
        if (treeType.equalsIgnoreCase("users")) {
            firebaseTree = new UsersTree();
        } else if (treeType.equalsIgnoreCase("homes")) {
            firebaseTree = new HomesTree();
        } else {
            return null;
        }
        return firebaseTree.getFirebase();
    }
}
