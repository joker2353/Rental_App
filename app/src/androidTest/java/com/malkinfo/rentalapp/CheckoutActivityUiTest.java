package com.malkinfo.rentalapp;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class CheckoutActivityUiTest {

    @Rule
    public IntentsTestRule<Checkout> intentsTestRule = new IntentsTestRule<>(Checkout.class);

    @Test
    public void testPaypalButtonClick() {
        // Click on the PayPal button
        Espresso.onView(withId(R.id.paypal)).perform(click());

        // Verify that Payment activity is started
        intended(hasComponent(Payment.class.getName()));
    }
}
