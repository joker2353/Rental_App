package com.malkinfo.rentalapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTypeTest {

    @Test
    public void testFlatWithAcRoom() {
        RoomType acRoom = new AcRoom("AC Room");
        House flat = new Flat(acRoom);
        assertEquals("AC Room", flat.getHouseDetails());
    }

    @Test
    public void testFlatWithNonAcRoom() {
        RoomType nonAcRoom = new NonAcRoom("Non-AC Room");
        House flat = new Flat(nonAcRoom);
        assertEquals("Non-AC Room", flat.getHouseDetails());
    }

    @Test
    public void testApartmentWithAcRoom() {
        RoomType acRoom = new AcRoom("AC Room");
        House apartment = new Apartment(acRoom);
        assertEquals("AC Room", apartment.getHouseDetails());
    }

    @Test
    public void testApartmentWithNonAcRoom() {
        RoomType nonAcRoom = new NonAcRoom("Non-AC Room");
        House apartment = new Apartment(nonAcRoom);
        assertEquals("Non-AC Room", apartment.getHouseDetails());
    }

}