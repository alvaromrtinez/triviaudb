package com.gatonaranja.triviaudb

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class InterstitialAdManager(private val context: Context) {
    //private lateinit var binding: ActivityInterstitialBinding
    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "InterstitialActivity"
    init{
        initAds()
        initListeners()
    }

    fun initAds(){
        // Build the new configuration and set it on the global MobileAds object.
        /*RequestConfiguration.MAX_AD_CONTENT_RATING_G);
        MobileAds.setRequestConfiguration(configurationBuilder.build());*/

        var adRequest = AdRequest.Builder().build()
        InterstitialAd.load(context,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                //Log .d(TAG, "Ad wasn't loaded")
                // Set a key to a string.
                log(TAG, "Ad wasn't loaded")
                /*val toast = Toast.makeText(context, "Ad wasn't loaded",  Toast.LENGTH_LONG)
                toast.show()*/
                mInterstitialAd = null
            }
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                //Log.d(TAG, "Ad was loaded.")
                log(TAG, "Ad was loaded")
                mInterstitialAd = interstitialAd
                //TEST ONLY
                /*val toast = Toast.makeText(context, "Ad was loaded",  Toast.LENGTH_LONG)
                toast.show()*/
                //TEST ONLY
            }
        })
    }

    fun initListeners(){
        mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
            override fun onAdClicked() {
                // Called when a click is recorded for an ad.
                //Log.d(TAG, "Ad was clicked.")
                log(TAG, "Ad was clicked.")
                /*val toast = Toast.makeText(context, "Ad was clicked",  Toast.LENGTH_LONG)
                toast.show()*/
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                //Log.d(TAG, "Ad dismissed fullscreen content.")
                log(TAG, "Ad dismissed fullscreen content.")
               /* val toast = Toast.makeText(context, "Ad dissmissed fullscreen content",  Toast.LENGTH_LONG)
                toast.show()*/
                mInterstitialAd = null
            }

            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                // Called when ad fails to show.
                //Log.e(TAG, "Ad failed to show fullscreen content.")
                log(TAG, "Ad failed to show fullscreen content.")
                /*val toast = Toast.makeText(context, "Ad failed to show fullscreen content",  Toast.LENGTH_LONG)
                toast.show()*/
                mInterstitialAd = null
            }

            override fun onAdImpression() {
                // Called when an impression is recorded for an ad.
                //Log.d(TAG, "Ad recorded an impression.")
                log(TAG, "Ad recorded an impression.")
                /*val toast = Toast.makeText(context, "Ad recorded an impression",  Toast.LENGTH_LONG)
                toast.show()*/
            }

            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
                log(TAG, "Ad showed fullscreen content.")
                /*val toast = Toast.makeText(context, "Ad showed fullscreen content",  Toast.LENGTH_LONG)
                toast.show()*/
                mInterstitialAd = null
            }
        }
    }
    fun showAds(){
        this.mInterstitialAd = mInterstitialAd
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(context as Activity)
        } else {
            log(TAG, "The interstitial ad wasn't ready yet.")
            /*val toast = Toast.makeText(context, "The interstitial ad wasn't ready yet",  Toast.LENGTH_LONG)
            toast.show()*/
            //Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }
    }
}