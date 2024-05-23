package com.malkinfo.rentalapp;

/**
 * The PaymentRole interface represents the role of processing payments.
 */
interface PaymentRole {

    /**
     * Processes a payment with the specified amount.
     *
     * @param amount The amount of the payment to be processed.
     * @return A message indicating the payment processing details.
     */
    String processPayment(double amount);
}

/**
 * The CreditCardProcessor class represents a concrete payment processor for credit card payments.
 * It implements the PaymentRole interface.
 */
class CreditCardProcessor implements PaymentRole {
    public CreditCardProcessor() {
    }

    /**
     * Processes a payment with a credit card.
     *
     * @param amount The amount of the payment to be processed.
     * @return A message indicating the credit card payment processing details.
     */
    @Override
    public String processPayment(double amount) {
        return "Processing payment with credit card: $" + amount;
    }
}

/**
 * The MobileBankingProcessor class represents a concrete payment processor for mobile banking payments.
 * It implements the PaymentRole interface.
 */
class MobileBankingProcessor implements PaymentRole {
    public MobileBankingProcessor() {
    }

    /**
     * Processes a payment with mobile banking.
     *
     * @param amount The amount of the payment to be processed.
     * @return A message indicating the mobile banking payment processing details.
     */
    @Override
    public String processPayment(double amount) {
        return "Processing payment with mobile banking: $" + amount;
    }
}

/**
 * The PaymentSystem class represents a system for processing payments.
 */
class PaymentSystem {
    private PaymentRole paymentRole;

    /**
     * Constructs a PaymentSystem instance.
     */
    public PaymentSystem() {
        this.paymentRole = paymentRole;
    }

    /**
     * Sets the payment role for the PaymentSystem.
     *
     * @param paymentRole The payment role to be set.
     */
    public void setPaymentRole(PaymentRole paymentRole) {
        this.paymentRole = paymentRole;
    }

    /**
     * Processes a payment with the currently set payment role.
     *
     * @param amount The amount of the payment to be processed.
     * @return A message indicating the payment processing details.
     */
    public String processPayment(double amount) {
        if (paymentRole != null) {
            return paymentRole.processPayment(amount);
        }
        return "No payment method selected";
    }
}
