package com.malkinfo.rentalapp;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class SignupUiTest {
    // Define a rule to launch the SignupActivity
    @Rule
    public ActivityScenarioRule<SignupActivity> activityScenarioRule = new ActivityScenarioRule<>(SignupActivity.class);
    @Test
    public void testSignupButton() {
        // Check if all necessary views are displayed
        Espresso.onView(withId(R.id.signup_name)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.signup_email)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.signup_username)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.signup_password)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.signup_button)).check(matches(isDisplayed()));
        Espresso.onView(withId(R.id.loginRedirectText)).check(matches(isDisplayed()));

        // Fill in signup details
        Espresso.onView(withId(R.id.signup_name)).perform(ViewActions.typeText("John Doe"));
        Espresso.onView(withId(R.id.signup_email)).perform(ViewActions.typeText("john@example.com"));
        Espresso.onView(withId(R.id.signup_username)).perform(ViewActions.typeText("johndoe"));
        Espresso.onView(withId(R.id.signup_password)).perform(ViewActions.typeText("password"), ViewActions.closeSoftKeyboard());

        // Click the signup button
        Espresso.onView(withId(R.id.signup_button)).perform(ViewActions.click());

//         Verify if the toast message is displayed
//        Espresso.onView(withText("You have signup successfully!"))
//                .inRoot(new ToastMatcher())
//                .check(matches(isDisplayed()));



        // Verify if the LoginActivity is launched
        Espresso.onView(ViewMatchers.withId(R.id.login_username)).check(matches(isDisplayed()));
    }

    // Additional tests can be added to validate edge cases and other scenarios
}

//public class ToastMatcher extends TypeSafeMatcher<Root> {
//
//    @Override
//    public void describeTo(Description description) {
//        description.appendText("is toast");
//    }
//
//    @Override
//    public boolean matchesSafely(Root root) {
//        int type = root.getWindowLayoutParams().get().type;
//        if (type == WindowManager.LayoutParams.TYPE_TOAST) {
//            IBinder windowToken = root.getDecorView().getWindowToken();
//            IBinder appToken = root.getDecorView().getApplicationWindowToken();
//            return windowToken == appToken;
//        }
//        return false;
//    }
//}