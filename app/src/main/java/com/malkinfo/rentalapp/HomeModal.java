package com.malkinfo.rentalapp;

public class HomeModal {
    public String price;
    public Integer id;
    public String location;
    public String description;
    public String shortDescription;
    public String image;

    public String getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getImage() {
        return image;
    }

    public HomeModal(Integer id, String price, String location, String description, String shortDescription, String image) {
        this.price = price;
        this.id = id;
        this.location = location;
        this.description = description;
        this.shortDescription = shortDescription;
        this.image = image;
    }
    public HomeModal() {
    }

}
