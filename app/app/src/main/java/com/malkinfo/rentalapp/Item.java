package com.malkinfo.rentalapp;

/**
 * The Item class represents an item for rental, such as a house or an apartment.
 */
public class Item {

    private String location;
    private String price;
    private String description;
    private String shortDescription;
    private String image;

    /**
     * Constructs an Item with the specified location, price, description, short description, and image.
     *
     * @param location        The location of the item.
     * @param price           The price of the item.
     * @param description     The detailed description of the item.
     * @param shortDescription The short description of the item.
     * @param image           The image URL of the item.
     */
    public Item(String location, String price, String description, String shortDescription, String image) {
        this.location = location;
        this.price = price;
        this.description = description;
        this.shortDescription = shortDescription;
        this.image = image;
    }

    /**
     * Constructs an empty Item.
     */
    public Item() {
    }

    // Getters and setters for private fields

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
