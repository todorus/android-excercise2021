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
            // Wait for data to be fetched. Good enough for an exercise.
            delay(5000)

            onView(withId(R.id.price)).check(matches(withText("43.49")))
            onView(withId(R.id.title)).check(matches(withText("Halo - The Master Chief Collection - Xbox One")))
            onView(withId(R.id.description)).check(matches(withText("Inhoud HALO - The Master Chief Collection Halo: Combat Evolved Anniversary Geremasterde Halo 2: Anniversary Halo 3 Halo 4 Nieuwe digitale series: Halo: Nightfall Toegang tot Halo 5: Guardians Beta. De ultieme Halo ervaring! Geoptimiseerd voor Xbox Series X beschikt over Smart Delivery en speelt af in 4K Ultra HD met 60 frames per seconde. Speelt op Xbox Series S, Xbox Series X en Xbox One. Het complete Master Chief-verhaal Het complete verhaal over deze iconische held en zijn epische reis wordt nu uitgebracht als The Master Chief Collection. Halo: Combat Evolved Anniversary, Halo 2: Anniversary, Halo 3, en Halo 4 zijn uitgevoerd met de 60fps beeldkwaliteit van de Xbox One, en bevatten in totaal 45 campagnemissies en meer dan 100 multiplayer (inclusief de originele Halo Combat Evolved-kaarten) en Spartan Ops-kaarten. Samen met de nieuwe proloog- en epiloogscènes als voorbode op Halo 5: Guardians, is dit de collectie voor de Xbox One waarop Halo-fans hebben gewacht. Halo 2: Anniversary De iconische held is na 10 jaar terug. Met een volledig geremasterde campagne met ‘Classic Mode’ waarmee je onmiddellijk kunt switchentussen de geremasterde versie en de originele game uit 2004. Ontdek de nieuwe Halo 5: Guardians-verhaalelementen in verborgen terminal-video’s en gebruik alle nieuwe skulls om de campagne op een hele nieuwe manier te ervaren. Ook alle 23 originele multiplayer-kaarten zitten erbij, naast 6 volledig opnieuw uitgevoerde kaarten. Speel het spel dat een hele nieuwe dimensie gaf aan multiplayer-games opconsoles, en bereid je voor op het volgende Halo-hoofdstuk. Master Menu Navigeer moeiteloos door het verhaal van The Master Chief met het volledig nieuwe Master Menu. Speel alle vier de volledig gedeblokkeerde campagnes van het begin tot het eind of duik middenin de actie. De game-ontwerpers voegden hun eigen playlists van campagnes toe voor nieuwe, spannende uitdagingen. Vind en speel moeiteloos je favoriete multiplayer-games uit meer dan 100 multiplayer en Spartan Ops-kaarten. Dat is alles wat er in Halo, op jouw voorwaarden, vereenvoudigd werd. New Halo: Nightfall Live Action Digital Series Een vreemde, vijandige wereld waarin UNSC-topagenten aan een nog groter gevaar worden blootgesteld in deze live actieserie van 343 Industries en Scott Free Productions. Met Ridley Scott en de directeur van Scott Free TV, David Zucker, als uitvoerend producenten en geregisseerd door Sergio Mimica-Gezzan (“Battlestar Galactica”, “Pillars of the Earth”, “Heroes”), is Halo: Nightfall een spannend nieuw verhaal voor oude én nieuwe Halo-fans. Halo 5: Guardians Multiplayer Beta Wees één van de eersten die de nieuwe generatie Halo-multiplayer speelt in Halo 5: Guardians Beta. Bereid je voor op de Guardians beta door de exclusieve content in The Master Chief Collection en Halo: Nightfall vrij te spelen. Deze exclusieve items neem je mee naar Halo 5: Guardians.")))

        }
    }
}

private fun UiAutomation.executeShellAndGetResponse(command: String): String {
    val fileDescriptor = executeShellCommand(command)
    val fileStream: InputStream = FileInputStream(fileDescriptor.fileDescriptor)
    return BufferedReader(InputStreamReader(fileStream)).readLine()
}