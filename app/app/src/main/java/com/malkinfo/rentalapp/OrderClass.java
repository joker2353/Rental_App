package com.malkinfo.rentalapp;

/**
 * The OrderClass represents an order in the rental application.
 * Each order has an ID and details associated with it.
 */
public class OrderClass {
    private String id;
    private String details;

    /**
     * Constructs an OrderClass object with the specified ID and details.
     *
     * @param id      The ID of the order.
     * @param details The details associated with the order.
     */
    public OrderClass(String id, String details) {
        this.id = id;
        this.details = details;
    }

    /**
     * Sets the ID of the order.
     *
     * @param id The ID of the order.
     */
    public void setPrice(String id) {
        this.id = id;
    }

    /**
     * Retrieves the ID of the order.
     *
     * @return The ID of the order.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the details of the order.
     *
     * @param details The details associated with the order.
     */
    public void setFeature(String details) {
        this.details = details;
    }

    /**
     * Retrieves the details of the order.
     *
     * @return The details associated with the order.
     */
    public String getDetails() {
        return this.details;
    }

    /**
     * Default constructor for the OrderClass.
     */
    public OrderClass() {
    }
}
