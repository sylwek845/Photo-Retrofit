package com.example.albumretrofit

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import com.example.albumretrofit.ui.album.AlbumActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var mActivityRule = ActivityTestRule<AlbumActivity>(AlbumActivity::class.java)

    @Test
    fun ensureControlsVisibility() {

        mActivityRule.activity.showLoading()
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
        onView(withId(R.id.list)).check(matches(not<View>(isDisplayed())))

        /**
         * Sleep should be replaced by Idling Listener to avoid slow connection failure or wasting time.
         */

        try {
            Thread.sleep(5000)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        onView(withId(R.id.list)).check(matches(isDisplayed()))
        onView(withId(R.id.progressBar)).check(matches(not<View>(isDisplayed())))

        /**
         * And so on...
         */
    }
}
