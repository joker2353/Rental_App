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

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.*;

@RunWith(AndroidJUnit4.class)
public class LoginuiTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() {
        // Initialize Espresso Intents
        Intents.init();
    }

    @After
    public void tearDown() {
        // Release Espresso Intents
        Intents.release();
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        // Click login button with empty username and password
        Espresso.onView(withId(R.id.login_button)).perform(click());

        // Check if error messages are displayed for both fields
        Espresso.onView(withId(R.id.login_username)).check(matches(hasErrorText("Username cannot be empty")));
        Espresso.onView(withId(R.id.login_password)).check(matches(hasErrorText("Password cannot be empty")));
    }

    @Test
    public void testInvalidCredentials() {
        // Use the provided test data
        String invalidUsername = "ttcsge";
        String invalidPassword = "bgngjg";

        // Type invalid username and password
        Espresso.onView(withId(R.id.login_username)).perform(typeText(invalidUsername));
        Espresso.onView(withId(R.id.login_password)).perform(typeText(invalidPassword), closeSoftKeyboard());


//        // Click login button
//        Espresso.onView(withId(R.id.login_button)).perform(click());
//
//        // Wait for error message to appear
//        Espresso.onView(withId(R.id.login_password))
//                .perform(ViewActions.actionWithAssertions(new ViewAction() {
//                    @Override
//                    public Matcher<View> getConstraints() {
//                        return ViewMatchers.isAssignableFrom(TextView.class);
//                    }
//
//                    @Override
//                    public String getDescription() {
//                        return "check if error text matches";
//                    }
//
//                    @Override
//                    public void perform(UiController uiController, View view) {
//                        // Perform assertions here
//                        EditText editText = (EditText) view;
//                        if (editText.getError() != null) {
//                            assertThat(editText.getError().toString(), is("Invalid Credentials"));
//                        } else {
//                            throw new AssertionError("Error text is null");
//                        }
//                    }
//                }));

    }




    // Add more tests as needed for different scenarios
}

