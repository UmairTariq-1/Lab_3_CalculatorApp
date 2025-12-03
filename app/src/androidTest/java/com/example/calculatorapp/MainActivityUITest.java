package com.example.calculatorapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import com.google.android.material.button.MaterialButton;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void Given_SimpleAddition_When_UserPressesButtons_Then_DisplayShowsCorrectResult() {
        // Clear any previous state
        onView(withText("C")).perform(click());

        // 12 + 3 =
        onView(withText("1")).perform(click());
        onView(withText("2")).perform(click());
        onView(withText("+")).perform(click());
        onView(withText("3")).perform(click());
        onView(withText("=")).perform(click());

        onView(withId(R.id.txtDisplay)).check(matches(withText("15")));
    }

    @Test
    public void Given_Operand_When_UserPressesSqrt_Then_DisplayShowsSquareRoot() {
        // Clear display
        onView(withText("C")).perform(click());

        // √9 = 3
        onView(withText("9")).perform(click());
        onView(withText("√")).perform(click());

        onView(withId(R.id.txtDisplay)).check(matches(withText("3")));
    }

    @Test
    public void Given_Zero_When_UserPressesReciprocal_Then_DisplayShowsError() {
        // Clear display first
        onView(withText("C")).perform(click());

        // Click the ZERO BUTTON, not the display
        onView(allOf(
                withText("0"),
                isAssignableFrom(MaterialButton.class)
        )).perform(click());

        // Click reciprocal button
        onView(withText("1/x")).perform(click());

        // Now check the DISPLAY by ID so there is no ambiguity
        onView(withId(R.id.txtDisplay))
                .check(matches(withText("Error")));
    }


    @Test
    public void Given_TwoDigitNumber_When_UserPressesBack_Then_LastDigitIsRemoved() {
        // Clear display
        onView(withText("C")).perform(click());

        // 12 -> back -> 1
        onView(withText("1")).perform(click());
        onView(withText("2")).perform(click());
        onView(withText("←")).perform(click());

        onView(withId(R.id.txtDisplay)).check(matches(withText("1")));
    }
}
