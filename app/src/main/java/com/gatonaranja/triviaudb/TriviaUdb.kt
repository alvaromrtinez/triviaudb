package com.gatonaranja.triviaudb

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import java.util.Arrays

class TriviaUdb : Application() {
    override fun onCreate() {
        super.onCreate()
       /* val testDeviceIds = Arrays.asList("CA8F6AC77421E9E3ECB9ECAB3F682F57")*/ //setTestDeviceId ONLY FOR TESTING
        var requestConfiguration = MobileAds.getRequestConfiguration()
            .toBuilder()
            .setTagForChildDirectedTreatment(RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
            .setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_PG)
            /*.setTestDeviceIds(testDeviceIds)*/ //setTestDevice ONLY FOR TESTING
            .build()
        //val configuration = RequestConfiguration.Builder()..build()
        MobileAds.setRequestConfiguration(requestConfiguration)
        MobileAds.initialize(this)
    }
}