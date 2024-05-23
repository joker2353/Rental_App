package com.malkinfo.rentalapp;

import android.app.Application;

import com.paypal.checkout.PayPalCheckout;
import com.paypal.checkout.config.CheckoutConfig;
import com.paypal.checkout.config.Environment;
import com.paypal.checkout.createorder.CurrencyCode;
import com.paypal.checkout.createorder.UserAction;

/**
 * The App class extends the Android Application class to initialize global application state.
 * It configures PayPalCheckout with necessary parameters for the PayPal payment integration.
 */
public class App extends Application {

    /**
     * Called when the application is starting, before any other application objects have been created.
     * Here, it initializes the PayPalCheckout with the configuration parameters.
     */
    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize PayPalCheckout with the required configuration
        PayPalCheckout.setConfig(new CheckoutConfig(
                this,
                "Aakwbag7yDJ7ZcL6KzQZhEQ42HO7muUz9V5Wg1205KYGd655GPX-nd5hDiE696CJZB7P0NiEeGj8TZf5", // Client ID
                Environment.SANDBOX, // Environment (Sandbox for testing)
                CurrencyCode.USD, // Currency Code
                UserAction.PAY_NOW, // User action to display on the PayPal button
                "com.devshiv.paypaltestjava://paypalpay" // Return URL
        ));
    }
}
