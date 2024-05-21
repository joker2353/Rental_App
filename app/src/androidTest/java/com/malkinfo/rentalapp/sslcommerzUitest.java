package com.malkinfo.rentalapp;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

public class sslcommerzUitest {
    @Rule
    public ActivityTestRule<sslcommerzActivity> activityRule =
            new ActivityTestRule<>(sslcommerzActivity.class, true, false);

    @Test
    public void testCreditCardProcessor() {
        Intent intent = new Intent();
        activityRule.launchActivity(intent);

        // Perform click on card button
        onView(withId(R.id.card)).perform(click());

        // Check if the text is updated correctly
        onView(withId(R.id.txt)).check(matches(withText("Processing payment with credit card: $100.0")));
    }

    @Test
    public void testMobileBankingProcessor() {
        Intent intent = new Intent();
        activityRule.launchActivity(intent);

        // Perform click on mobile banking button
        onView(withId(R.id.mb)).perform(click());

        // Check if the text is updated correctly
        onView(withId(R.id.txt)).check(matches(withText("Processing payment with mobile banking: $50.0")));
    }
}
