package com.example.android.twoactivities;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by lingaraj on 11/5/17.
 */

@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);


    //@Test
    public void activityLaunch(){
        onView(withId(R.id.button_main)).perform(click());
        onView(withId(R.id.text_header)).check(matches(isDisplayed()));
        onView(withId(R.id.button_second)).perform(click());
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()));

    }

    @Test
    public void testEditTextInputOutput(){
        String text_one ="Hai man how are you";
        String text_reply = "Good, how is your life going bro";
        onView(withId(R.id.editText_main)).perform(typeText(text_one));
        onView(withId(R.id.button_main)).perform(click());
        onView(withId(R.id.text_message)).check(matches(withText(text_one)));
        onView(withId(R.id.editText_second)).perform(typeText(text_reply));
        onView(withId(R.id.button_second)).perform(click());
        onView(withId(R.id.text_message_reply)).check(matches(withText(text_reply)));

    }
}
