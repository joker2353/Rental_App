package com.malkinfo.rentalapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class HomeModalTest {

    @Test
    public void testHomeModalConstructor() {
        Integer id = 1;
        String price = "$2000";
        String location = "New York";
        String description = "Spacious apartment in the heart of the city.";
        String shortDescription = "Spacious apartment";
        String image = "https://example.com/apartment.jpg";

        HomeModal homeModal = new HomeModal(id, price, location, description, shortDescription, image);

        assertNotNull(homeModal);
        assertEquals(id, homeModal.getId());
        assertEquals(price, homeModal.getPrice());
        assertEquals(location, homeModal.getLocation());
        assertEquals(description, homeModal.getDescription());
        assertEquals(shortDescription, homeModal.getShortDescription());
        assertEquals(image, homeModal.getImage());
    }

    @Test
    public void testHomeModalDefaultConstructor() {
        HomeModal homeModal = new HomeModal();

        assertNotNull(homeModal);
        // Test default values (should be null for String fields and 0 for Integer field)
        assertEquals(null, homeModal.getId());
        assertEquals(null, homeModal.getPrice());
        assertEquals(null, homeModal.getLocation());
        assertEquals(null, homeModal.getDescription());
        assertEquals(null, homeModal.getShortDescription());
        assertEquals(null, homeModal.getImage());
    }
}
