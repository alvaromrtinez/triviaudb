package com.gatonaranja.triviaudb

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gatonaranja.triviaudb.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferences: SharedPreferences
    private lateinit var savedLanguage: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
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
            val text = "NO SE RECUPERO EL IDIOMA"
            val toast = Toast.makeText(this, text,  Toast.LENGTH_LONG) // in Activity
            toast.show()
        }
        setAppLocale()
        // Habilita el modo inmersivo (pantalla completa) para la actividad
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
        //replaceFragment(MenuFragment())
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
        //sharedPreferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE)
        //USAR EN PRUEBAS
        /*val idiomaRecuperado = preferences.getString(preferencia, valorPredeterminado) ?: valorPredeterminado
        val text = "El idioma recuperado es: $idiomaRecuperado"
        val toast = Toast.makeText(this, text,  Toast.LENGTH_LONG) // in Activity
        toast.show()*/
        //USAR EN PRUEBAS
        return preferences.getString(Preferences.LANGUAGE, valorPredeterminado) ?: valorPredeterminado
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.navHostFragment,fragment)
        fragmentTransaction.commit()
    }
}