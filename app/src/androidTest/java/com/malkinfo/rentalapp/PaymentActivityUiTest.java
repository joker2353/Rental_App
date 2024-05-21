package com.malkinfo.rentalapp;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PaymentActivityUiTest {

    @Rule
    public ActivityTestRule<Payment> activityRule = new ActivityTestRule<>(Payment.class);

    @Test
    public void testPaymentButtonDisplayed() {
        // Check if the payment button container is displayed
        onView(withId(R.id.payment_button_container)).check(matches(isDisplayed()));
    }

//    @Test
//    public void testPaymentButtonDisplayed() {
//        // Wait for 2 seconds
//        IdlingResource idlingResource = new ElapsedTimeIdlingResource(2000);
//        IdlingRegistry.getInstance().register(idlingResource);
//
//        // Check if the payment button container is displayed
//        onView(withId(R.id.payment_button_container)).check(matches(isDisplayed()));
//
//        // Unregister the idling resource
//        IdlingRegistry.getInstance().unregister(idlingResource);
//    }


    // You can write more tests here to verify the behavior of the Payment activity
}
