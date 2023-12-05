package com.gatonaranja.triviaudb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.gatonaranja.triviaudb.databinding.ActivityResultsBinding
import java.util.Locale

class Results : AppCompatActivity() {

    private lateinit var binding: ActivityResultsBinding
    private lateinit var preferences: SharedPreferences
    private lateinit var savedLanguage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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
        changeButtonsImages(savedLanguage)
        // Habilita el modo inmersivo (pantalla completa) para la actividad
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
        /*tvCorrectas = findViewById(R.id.tv_correctas)
        tvIncorrectas = findViewById(R.id.tv_incorrectas)*/

        val extras = intent.extras
        val getCorrectas = extras?.getString("correctas", 0.toString())
        val getIncorrectas = extras?.getString("incorrectas", 0.toString())
        val correctasTxt = resources.getString(R.string.tv_correctas_String)
        val incorrectasTxt = resources.getString(R.string.tv_incorrectas_String)
        val score = getCorrectas!!.toInt()
        checkScore(score)
        setNewRecords(getCorrectas!!.toInt(), getIncorrectas!!.toInt())
        //PRUEBAS
        //val case = checkScore(score)
        //PRUEBAS

        binding.tvCorrectas?.setText(correctasTxt+ getCorrectas)
        binding.tvIncorrectas?.setText(incorrectasTxt + getIncorrectas)

        //PRUEBAS
        //binding.tvScoretest?.setText(case.toString())
        //PRUEBAS

        binding.btnResults.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
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

    fun changeButtonsImages(savedLanguage: String){
        if(savedLanguage=="en"){
            binding.btnResults.setBackgroundResource(R.drawable.backtomenubtnen)
            return
        }
        binding.btnResults.setBackgroundResource(R.drawable.backtomenubtn)
    }


    private fun checkScore(getCorrectas: Int): Int{
        //de 0-50 mostrar mensaje de aliento   (0 a 25 preguntas correctas)
        if(getCorrectas <=25){
            setResources(getString(R.string.tv_shame_String), R.drawable.scared,getString(R.string.tv_sentenceOne_String))
            return 0
        }
        //de 50-70 mostrar mensaje de nada mal (26 a 35 preguntas correctas)
        if(getCorrectas <=35){
            setResources(getString(R.string.tv_almost_String),R.drawable.studying,getString(R.string.tv_sentenceTwo_String))
            return 2
        }
        //de 70-100 mostrar cinturon de campeón y frase ganadora 36 a 50 preguntas))
        setResources(getString(R.string.tv_congrats_String),R.drawable.championbelt,getString(R.string.tv_sentenceThree_String))
        return 1
    }
    private fun saveScore(correctsValue: Int, incorrectsValue: Int){
        val editor = preferences.edit()
        editor.putInt(Preferences.CORRECTANSWERS, correctsValue)// Cambia
        editor.putInt(Preferences.INCORRECTANSWERS, incorrectsValue)// Cambia
        editor.apply() // Guarda los cambios
    }
    private fun getSavedScore(valorPredeterminado: Int): Int{
        return preferences.getInt(Preferences.CORRECTANSWERS, valorPredeterminado) ?: valorPredeterminado
    }
    private fun setNewRecords(getCorrectas: Int, getIncorrectas: Int){
        var savedScore = getSavedScore(0)
        if (getCorrectas > savedScore){
            saveScore(getCorrectas, getIncorrectas)
            val toast = Toast.makeText(this, "Registro guardado",  Toast.LENGTH_SHORT) // in Activity
            toast.show()
        }
    }
    private fun setResources(mainText: String, Image: Int, sentence: String){
        binding.tvTitle?.setText(mainText)
        binding.ivReward?.setImageResource(Image)
        binding.tvSentence?.setText(sentence)
        binding.tvResultstwo?.setText(R.string.tv_results2_String)
    }

}