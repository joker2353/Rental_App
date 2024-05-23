package com.malkinfo.rentalapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaymentRoleTest {
    private PaymentSystem paymentSystem;
    private PaymentRole creditCardProcessor;
    private PaymentRole mobileBankingProcessor;

    @Before
    public void setUp() {
        paymentSystem = new PaymentSystem();
        creditCardProcessor = new CreditCardProcessor();
        mobileBankingProcessor = new MobileBankingProcessor();
    }

    @Test
    public void testProcessPaymentWithCreditCard() {
        paymentSystem.setPaymentRole(creditCardProcessor);
        String result = paymentSystem.processPayment(100.0);
        assertEquals("Processing payment with credit card: $100.0", result);
    }

    @Test
    public void testProcessPaymentWithMobileBanking() {
        paymentSystem.setPaymentRole(mobileBankingProcessor);
        String result = paymentSystem.processPayment(150.0);
        assertEquals("Processing payment with mobile banking: $150.0", result);
    }

    @Test
    public void testProcessPaymentWithoutSelectingPaymentMethod() {
        String result = paymentSystem.processPayment(200.0);
        assertEquals("No payment method selected", result);
    }

}