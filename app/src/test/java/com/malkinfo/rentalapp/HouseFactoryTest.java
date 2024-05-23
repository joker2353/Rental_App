package com.malkinfo.rentalapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class HouseFactoryTest {

    @Test
    public void testFeatureFactory_AC() {
        FeatureType feature = FeatureFactory.getfeature("AC");
        assertNotNull(feature);
        assertEquals("AC", feature.getTypeName());
    }

    @Test
    public void testFeatureFactory_NonAC() {
        FeatureType feature = FeatureFactory.getfeature("Non AC");
        assertNotNull(feature);
        assertEquals("Non AC", feature.getTypeName());
    }

    @Test
    public void testFeatureFactory_WindowSide() {
        FeatureType feature = FeatureFactory.getfeature("Window Side");
        assertNotNull(feature);
        assertEquals("Window Side", feature.getTypeName());
    }

    @Test
    public void testFeatureFactory_Null() {
        FeatureType feature = FeatureFactory.getfeature(null);
        assertNull(feature);
    }

    @Test
    public void testHouseFactory_Flat() {
        FeatureType feature = new ac("AC");
        House house = HouseFactory.gethouseType("Flat", feature);
        assertNotNull(house);
        assertEquals("Flat with AC", house.getHouseDetails());
    }

    @Test
    public void testHouseFactory_Apartment() {
        FeatureType feature = new nonac("Non AC");
        House house = HouseFactory.gethouseType("Apartment", feature);
        assertNotNull(house);
        assertEquals("Apartment with Non AC", house.getHouseDetails());
    }

    @Test
    public void testHouseFactory_Null() {
        House house = HouseFactory.gethouseType(null, null);
        assertNull(house);
    }
}
