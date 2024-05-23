package com.malkinfo.rentalapp;

import static org.junit.Assert.*;



import org.junit.Test;
import static org.junit.Assert.*;

public class OrderClassTest {

    @Test
    public void testGetId() {
        String id = "123";
        String details = "Some details";

        OrderClass order = new OrderClass(id, details);

        assertEquals(id, order.getId());
    }

    @Test
    public void testGetDetails() {
        String id = "123";
        String details = "Some details";

        OrderClass order = new OrderClass(id, details);

        assertEquals(details, order.getDetails());
    }

    @Test
    public void testSetId() {
        String id = "123";
        String newId = "456";
        String details = "Some details";

        OrderClass order = new OrderClass(id, details);
        order.setPrice(newId);

        assertEquals(newId, order.getId());
    }

    @Test
    public void testSetDetails() {
        String id = "123";
        String details = "Some details";
        String newDetails = "New details";

        OrderClass order = new OrderClass(id, details);
        order.setFeature(newDetails);

        assertEquals(newDetails, order.getDetails());
    }
}