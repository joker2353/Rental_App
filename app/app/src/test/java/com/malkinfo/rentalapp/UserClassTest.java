package com.malkinfo.rentalapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserClassTest {
    private UserClass user;

    @Before
    public void setUp() {
        user = new UserClass("John Doe", "john.doe@example.com", "johndoe", "password123");
    }

    @Test
    public void testUserConstructor() {
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("johndoe", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertNull(user.getImage());
    }

    @Test
    public void testSetName() {
        user.setName("Jane Doe");
        assertEquals("Jane Doe", user.getName());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", user.getEmail());
    }

    @Test
    public void testSetUsername() {
        user.setUsername("janedoe");
        assertEquals("janedoe", user.getUsername());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void testSetImage() {
        user.setImage("imagepath.jpg");  // Directly setting the image since there's no setter method
        assertEquals("imagepath.jpg", user.getImage());
    }

    @Test
    public void testDefaultConstructor() {
        UserClass defaultUser = new UserClass();
        assertNull(defaultUser.getName());
        assertNull(defaultUser.getEmail());
        assertNull(defaultUser.getUsername());
        assertNull(defaultUser.getPassword());
        assertNull(defaultUser.getImage());
    }
}