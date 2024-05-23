package com.malkinfo.rentalapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class IntegrationTestIT {

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

    @Test
    public void testProcessPaymentWithCreditCard() {

        PaymentSystem paymentSystem = new PaymentSystem();
        PaymentRole creditCardProcessor = new CreditCardProcessor();

        paymentSystem.setPaymentRole(creditCardProcessor);
        String result = paymentSystem.processPayment(100.0);
        assertEquals("Processing payment with credit card: $100.0", result);
    }

    @Test
    public void testProcessPaymentWithMobileBanking() {

        PaymentSystem paymentSystem = new PaymentSystem();
        PaymentRole mobileBankingProcessor = new MobileBankingProcessor();

        paymentSystem.setPaymentRole(mobileBankingProcessor);
        String result = paymentSystem.processPayment(150.0);
        assertEquals("Processing payment with mobile banking: $150.0", result);
    }

    @Test
    public void testProcessPaymentWithoutSelectingPaymentMethod() {

        PaymentSystem paymentSystem = new PaymentSystem();
        String result = paymentSystem.processPayment(200.0);
        assertEquals("No payment method selected", result);
    }
}
