package com.malkinfo.rentalapp;

/**
 * The HomeModal class represents the model for a home item in the application.
 * It contains properties such as price, location, description, short description, and image URL.
 */
public class HomeModal {
    public String price;
    public Integer id;
    public String location;
    public String description;
    public String shortDescription;
    public String image;

    /**
     * Constructor to initialize a HomeModal object.
     *
     * @param id              The unique identifier of the home item.
     * @param price           The price of the home item.
     * @param location        The location of the home item.
     * @param description     The detailed description of the home item.
     * @param shortDescription The short description of the home item.
     * @param image           The URL of the image associated with the home item.
     */
    public HomeModal(Integer id, String price, String location, String description, String shortDescription, String image) {
        this.price = price;
        this.id = id;
        this.location = location;
        this.description = description;
        this.shortDescription = shortDescription;
        this.image = image;
    }

    /**
     * Default constructor.
     */
    public HomeModal() {
    }

    /**
     * Gets the price of the home item.
     *
     * @return The price of the home item.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Gets the unique identifier of the home item.
     *
     * @return The unique identifier of the home item.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets the location of the home item.
     *
     * @return The location of the home item.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the detailed description of the home item.
     *
     * @return The detailed description of the home item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the short description of the home item.
     *
     * @return The short description of the home item.
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Gets the URL of the image associated with the home item.
     *
     * @return The URL of the image associated with the home item.
     */
    public String getImage() {
        return image;
    }
}
