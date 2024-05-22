package com.malkinfo.rentalapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public interface FirebaseTree {
    DatabaseReference getFirebase();
}
class HomesTree implements FirebaseTree{
    private FirebaseDatabase database;
    private  DatabaseReference reference;
    public HomesTree() {
        database=Firebase.getFirebase();
    }
    @Override
    public DatabaseReference getFirebase(){
        reference = database.getReference("homes");
        return reference;
    }
}

class OrdersTree implements FirebaseTree{
    private FirebaseDatabase database;
    private  DatabaseReference reference;
    public OrdersTree() {
        database=Firebase.getFirebase();
    }
    @Override
    public DatabaseReference getFirebase(){
        reference = database.getReference("orders");
        return reference;
    }
}

class UsersTree implements FirebaseTree{
    private FirebaseDatabase database;
    private  DatabaseReference reference;
    public UsersTree() {
        database=Firebase.getFirebase();
    }
    @Override
    public DatabaseReference getFirebase(){
        reference = database.getReference("users");
        return reference;
    }
}

class TreeFactory{
    private FirebaseTree firebasetree;
    public DatabaseReference getFirebaseTree(String treeType){
        if(treeType.equalsIgnoreCase("users")){
            firebasetree = new UsersTree();
        }
        else if(treeType.equalsIgnoreCase("homes")){
            firebasetree = new HomesTree();
        }
        else if(treeType.equalsIgnoreCase("orders")){
            firebasetree = new OrdersTree();
        }
        else{
            return null;
        }
        return firebasetree.getFirebase();
    }
}

