package com.example.nu.models;

import java.io.Serializable;

public class FridgeItem implements Serializable {
    private String id;
    private final String name;

    public FridgeItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

//    public Item(DataSnapshot snapshot) {
//        this.id = snapshot.getKey();
//        this.name = (String) snapshot.child("name").getValue();
//        this.datePurchased = (String) snapshot.child("DOP").getValue();
//    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }
}