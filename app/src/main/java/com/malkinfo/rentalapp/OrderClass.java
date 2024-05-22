package com.malkinfo.rentalapp;

public class OrderClass {
    private String id;
    //private List<Integer> images;
    private String details;

    public OrderClass(String id, String details) {

        this.id = id;

       this.details=details;
    }

    public void setPrice(String id) {
        this.id = id;
    }
    public String getId(){
        return this.id;
    }


    public  void setFeature(String details){ this.details=details;}
    public String getDetails(){
        return this.details;
    }


    public OrderClass() {
    }

}
