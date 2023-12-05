package com.gatonaranja.triviaudb

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import java.util.Arrays

class TriviaUdb : Application() {
    override fun onCreate() {
        super.onCreate()
        val testDeviceIds = Arrays.asList("CA8F6AC77421E9E3ECB9ECAB3F682F57")
        var requestConfiguration = MobileAds.getRequestConfiguration()
            .toBuilder()
            .setTagForChildDirectedTreatment(RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
            .setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_PG)
            .setTestDeviceIds(testDeviceIds)
            .build()
        //val configuration = RequestConfiguration.Builder()..build()
        MobileAds.setRequestConfiguration(requestConfiguration)
        MobileAds.initialize(this)
        //setContentView(R.layout.activity_splash_screen)
        /*val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish();*/

        // Mostrar el SplashScreen usando una actividad
        /*val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        MobileAds.initialize(this)*/

        /*val delayMillis: Long = 3000 // Agrega un retardo de 2000 milisegundos (2 segundos)
        val handler = Handler() // Crea un nuevo objeto Handler
        handler.postDelayed({// Postea un Runnable después del retardo
            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent) // Crea y muestra el AlertDialog después del retardo
        }, delayMillis)*/
    }
}