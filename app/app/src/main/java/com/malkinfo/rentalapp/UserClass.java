package com.malkinfo.rentalapp;

/**
 * The UserClass class represents a user with basic information such as name, email, username, and password.
 * It provides methods to retrieve and update this information.
 */
public class UserClass {
    private String name;
    private String email;
    private String password;
    private String username;

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    /**
     * Constructs a UserClass object with the specified name, email, username, and password.
     * @param name The name of the user.
     * @param email The email address of the user.
     * @param username The username chosen by the user.
     * @param password The password chosen by the user.
     */
    public UserClass(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    /**
     * Retrieves the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the email address of the user.
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the username of the user.
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the image URL of the user's profile picture.
     * @return The image URL of the user's profile picture.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the name of the user.
     * @param name The new name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the email address of the user.
     * @param email The new email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the password of the user.
     * @param password The new password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the username of the user.
     * @param username The new username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Constructs an empty UserClass object.
     */
    public UserClass() {
    }
}
