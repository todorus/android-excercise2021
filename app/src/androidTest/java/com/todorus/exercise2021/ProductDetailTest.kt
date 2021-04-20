package com.todorus.exercise2021

import android.app.UiAutomation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.todorus.exercise2021.util.lazyActivityScenarioRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ProductDetailTest {

    private lateinit var windowAnimationScale: String
    private lateinit var transitionAnimationScale: String
    private lateinit var animatorDurationScale: String
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    val rule = lazyActivityScenarioRule<MainActivity>(launchActivity = false)

    @Before
    fun setup() {
        val uiAutomation = InstrumentationRegistry.getInstrumentation().uiAutomation
        disableAnimations(uiAutomation)
    }

    private fun disableAnimations(uiAutomation: UiAutomation) {
        windowAnimationScale = uiAutomation.executeShellAndGetResponse("settings get global window_animation_scale")
        transitionAnimationScale = uiAutomation.executeShellAndGetResponse("settings get global transition_animation_scale")
        animatorDurationScale = uiAutomation.executeShellAndGetResponse("settings get global animator_duration_scale")

        uiAutomation.executeShellCommand("settings put global window_animation_scale 0")
        uiAutomation.executeShellCommand("settings put global transition_animation_scale 0")
        uiAutomation.executeShellCommand("settings put global animator_duration_scale 0")
    }

    @After
    fun restoreAnimations() {
        val uiAutomation = InstrumentationRegistry.getInstrumentation().uiAutomation
        uiAutomation.executeShellCommand("settings put global window_animation_scale $windowAnimationScale")
        uiAutomation.executeShellCommand("settings put global transition_animation_scale $transitionAnimationScale")
        uiAutomation.executeShellCommand("settings put global animator_duration_scale $animatorDurationScale")
    }

    @Test
    fun it_should_show_product_properties() {
        runBlocking {
            rule.launch()
            // Wait for data to be fetched. Good enough for an exercise, but not production.
            delay(5000)

            onView(withId(R.id.price)).check(matches(withText("43.49")));
        }
    }
}

private fun UiAutomation.executeShellAndGetResponse(command: String): String {
    val fileDescriptor = executeShellCommand(command)
    val fileStream: InputStream = FileInputStream(fileDescriptor.fileDescriptor)
    return BufferedReader(InputStreamReader(fileStream)).readLine()
}