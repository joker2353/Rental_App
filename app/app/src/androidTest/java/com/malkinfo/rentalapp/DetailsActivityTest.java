package com.malkinfo.rentalapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class DetailsActivityTest {

    @Rule
    public ActivityScenarioRule<DetailsActivity> activityScenarioRule =
            new ActivityScenarioRule<>(DetailsActivity.class);

//    @Test
//    public void testActivityInView() {
//        onView(ViewMatchers.withId(R.id.activity_details)).check(matches(isDisplayed()));
//    }

    @Test
    public void testViewsInitialized() {
        onView(ViewMatchers.withId(R.id.imageView)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.price)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.short_description)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.description)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.applying)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.autoCompleteTextView)).check(matches(isDisplayed()));
    }
}
