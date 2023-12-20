package com.gatonaranja.triviaudb

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.gatonaranja.triviaudb.databinding.ActivityMainBinding
import com.gatonaranja.triviaudb.databinding.DialogFeedbackBinding
import com.google.firebase.remoteconfig.BuildConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferences: SharedPreferences
    private lateinit var savedLanguage: String
    private val dialog = Dialog()
    private val firebaseRemoteConfig by lazy { FirebaseRemoteConfig.getInstance() }

    private val configSettings by lazy {
        FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds((if (BuildConfig.DEBUG) 0 else 3600))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //MobileAds.initialize(this)
        /*installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
       }*/
        setTheme(R.style.Theme_TriviaUdb)
        setContentView(view)

        preferences = getSharedPreferences(Preferences.DATA, Context.MODE_PRIVATE)
        try {
            savedLanguage = getLanguage("es")
        } catch (e: Exception) {
            e.printStackTrace()
            log("LANGUAGE", "NO SE RECUPERO EL IDIOMA")
        }
        setAppLocale()
        // Habilita el modo inmersivo (pantalla completa) para la actividad
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
        check()
        //replaceFragment(MenuFragment())
    }

    init {
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
    }
    private fun check() {
        val appVersion = ForceUpdateUtils.getAppVersion(this)
        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(this) {
            if (it.isSuccessful) {
                val forceUpdate = firebaseRemoteConfig.getBoolean(KEY_FORCE_UPDATE_REQUIRED)
                val currentVersion = firebaseRemoteConfig.getString(KEY_CURRENT_VERSION)
               /*val text = "La versión de app es: $appVersion y la versión actual ess: $currentVersion"
                val toast = Toast.makeText(this, text,  Toast.LENGTH_LONG)
                toast.show()*/
                if (forceUpdate) {
                    if (currentVersion > appVersion) {
                        showDialog()
                    }
                }
            }
        }
    }
    private fun showDialog() {
        dialog.show(supportFragmentManager, "Exit Dialog")
    }

    companion object {
        const val KEY_CURRENT_VERSION = "android_force_update_current_version"
        const val KEY_FORCE_UPDATE_REQUIRED = "android_force_update_required"
    }

    private fun setAppLocale() {
        val savedLanguage = getLanguage("es")
        val locale = Locale(savedLanguage)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    fun getLanguage(valorPredeterminado: String): String {
        return preferences.getString(Preferences.LANGUAGE, valorPredeterminado) ?: valorPredeterminado
        //sharedPreferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE)
        //USAR EN PRUEBAS
        /*val idiomaRecuperado = preferences.getString(preferencia, valorPredeterminado) ?: valorPredeterminado
        val text = "El idioma recuperado es: $idiomaRecuperado"
        val toast = Toast.makeText(this, text,  Toast.LENGTH_LONG) // in Activity
        toast.show()*/
        //USAR EN PRUEBAS
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.navHostFragment,fragment)
        fragmentTransaction.commit()
    }
}