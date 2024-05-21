package com.malkinfo.rentalapp;

import android.content.Intent;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class DetailsActivityUiTest {

//    @Rule
//    public ActivityTestRule<DetailsActivity> activityRule = new ActivityTestRule<>(DetailsActivity.class, false, false);
//
//    @Rule
//    public IntentsTestRule<DetailsActivity> intentsTestRule = new IntentsTestRule<>(DetailsActivity.class);
//
//    @Test
//
//    public void testDetailsActivity() {
//        // Launch DetailsActivity with intent extras
//        Intent intent = new Intent();
//        intent.putExtra("price", "$1000");
//        intent.putExtra("description", "This is a great apartment.");
//        intent.putExtra("shortDescription", "Great Apartment");
//        intent.putExtra("image", "https://example.com/image.jpg");
//
//        activityRule.launchActivity(intent);
//
//        // Check if the details are displayed correctly
//        onView(withId(R.id.price)).check(matches(withText("$1000")));
//        onView(withId(R.id.description)).check(matches(withText("This is a great apartment.")));
//        onView(withId(R.id.short_description)).check(matches(withText("Great Apartment")));
//
//        // Select an item from the AutoCompleteTextView
//        onView(withId(R.id.autoCompleteTextView))
//                .perform(click())
//                .perform(replaceText("Java"));
//
//        // Click the apply button and check if the Checkout activity is started
//        onView(withId(R.id.applying)).perform(click());
//        intended(hasComponent(Checkout.class.getName()));
//    }

}
