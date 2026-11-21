package com.mrpython.app.ads

import android.app.Activity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform
import com.mrpython.app.R

/**
 * Full-screen ads between lessons for learners who have not bought the full course.
 * Nothing here runs once the course is bought: no consent form, no ad requests.
 *
 * Call everything from the main thread.
 */
object AdsManager {
    private var started = false
    private var initialized = false
    private var loading = false
    private var ad: InterstitialAd? = null
    private var lastShownMillis = 0L

    /** At most one ad in this many milliseconds, so short replays are not interrupted each time. */
    private const val MIN_GAP_MILLIS = 3 * 60 * 1000L

    /**
     * Asks for the advertising consent where the law requires it (EU, UK), then prepares the
     * first ad. Safe to call again; it does the work once.
     */
    fun start(activity: Activity) {
        if (started) return
        started = true
        val consent = UserMessagingPlatform.getConsentInformation(activity)
        consent.requestConsentInfoUpdate(
            activity,
            ConsentRequestParameters.Builder().build(),
            {
                UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity) {
                    if (consent.canRequestAds()) initialize(activity)
                }
            },
            {
                // Usually no connection. Use an earlier consent if there is one, and try again
                // the next time an ad is due.
                if (consent.canRequestAds()) initialize(activity) else started = false
            },
        )
        // A consent given in an earlier session lets ads load without waiting for the update.
        if (consent.canRequestAds()) initialize(activity)
    }

    private fun initialize(activity: Activity) {
        if (initialized) return
        initialized = true
        MobileAds.initialize(activity.applicationContext) { }
        load(activity)
    }

    private fun load(activity: Activity) {
        if (!initialized || loading || ad != null) return
        loading = true
        InterstitialAd.load(
            activity.applicationContext,
            activity.getString(R.string.admob_interstitial_id),
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(loaded: InterstitialAd) {
                    loading = false
                    ad = loaded
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    loading = false
                }
            },
        )
    }

    /** True where the law gives the learner the right to change the ad consent later (EU, UK). */
    fun privacyOptionsRequired(activity: Activity): Boolean =
        UserMessagingPlatform.getConsentInformation(activity).privacyOptionsRequirementStatus ==
            ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED

    /** Opens Google's form for changing the ad consent. */
    fun showPrivacyOptions(activity: Activity) {
        UserMessagingPlatform.showPrivacyOptionsForm(activity) { }
    }

    /**
     * Shows an ad if one is ready and the last one was long enough ago, then calls [then].
     * [then] always runs exactly once, with or without an ad.
     */
    fun showThen(activity: Activity?, then: () -> Unit) {
        val ready = ad
        val now = System.currentTimeMillis()
        if (activity == null || ready == null || now - lastShownMillis < MIN_GAP_MILLIS) {
            activity?.let { if (initialized) load(it) else start(it) }
            then()
            return
        }
        ad = null
        lastShownMillis = now
        var finished = false
        fun finish() {
            if (finished) return
            finished = true
            load(activity)
            then()
        }
        ready.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() = finish()
            override fun onAdFailedToShowFullScreenContent(error: AdError) = finish()
        }
        ready.show(activity)
    }
}
