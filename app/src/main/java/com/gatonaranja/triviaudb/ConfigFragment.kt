package com.gatonaranja.triviaudb

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.Locale
import com.gatonaranja.triviaudb.databinding.FragmentConfigBinding
import android.content.pm.PackageManager

class ConfigFragment : Fragment(),View.OnClickListener {

    private lateinit var preferences: SharedPreferences
    private var _binding: FragmentConfigBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConfigBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = activity?.getSharedPreferences(Preferences.DATA, Context.MODE_PRIVATE)!!
        binding.cvSpanish.setOnClickListener(this)
        binding.cvEnglish.setOnClickListener(this)
        binding.cvMusic.setOnClickListener(this)
        binding.cvSounds.setOnClickListener(this)
        setSavedImages()
        binding.ivBack.setOnClickListener(){
            //replaceFragment(MenuFragment())
            requireActivity().onBackPressed()
        }
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cv_spanish -> {
                changeLanguage("es")
                binding.cvSpanish.setCardBackgroundColor(Color.parseColor("#AAABAE")) // Cambia el color de fondo aquí
                binding.cvEnglish.setCardBackgroundColor(Color.parseColor("#FFFFFF")) // Restablece el color de fondo
                binding.cvSpanish.isEnabled = false
                binding.cvEnglish.isEnabled = true
                //change language, highlight cardview,disabled and saved shared preferences
            }
            R.id.cv_english -> {
                changeLanguage("en")
                binding.cvSpanish.setCardBackgroundColor(Color.parseColor("#AAABAE")) // Restablece el color de fondo
                binding.cvEnglish.setCardBackgroundColor(Color.parseColor("#FF0000")) // Cambia el color de fondo aquí
                binding.cvEnglish.isEnabled = false
                binding.cvSpanish.isEnabled = true
            }
            R.id.cv_music -> {
                checkMusicStatus()
            }
            R.id.cv_sounds -> {
                checkSoundsStatus()
            }
        }
    }
    fun changeLanguage(language: String){
        //ChangeLanguage
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        val context = ContextWrapper(requireContext()).createConfigurationContext(config)
        resources.updateConfiguration(config, resources.displayMetrics)
        setLanguage(language)
        binding.tvConfig.text = getString(R.string.tv_config_String)
        binding.tvLanguage.text = getString(R.string.tv_language_String)
        binding.tvSpanish.text = getString(R.string.tv_spanish_String)
        binding.tvEnglish.text = getString(R.string.tv_english_String)
        binding.tvSound.text = getString(R.string.tv_sound_String)
        binding.tvFx.text = getString(R.string.tv_fx_String)
        binding.tvMusic.text = getString(R.string.tv_music_String)
        // Reinicia la actividad para aplicar el cambio de idioma
        //replaceFragment(ConfigFragment())
        //restartActivity()
    }

    fun setLanguage(valor: String) {
        val editor = preferences.edit()
        editor.putString(Preferences.LANGUAGE, valor)// Cambia "es" al valor seleccionado por el usuario
        editor.apply() // Guarda los cambios
        //TEST ONLY
        /*val text = "El Idioma Fue Cambiado A: $valor"
        val toast = Toast.makeText(context, text,  Toast.LENGTH_SHORT) // in Activity
        toast.show()*/ //TEST ONLY
        //USAR EN PRUEBAS
    }

    fun getMusicStatus(valorPredeterminado: Int): Int {
        return preferences.getInt(Preferences.MUSIC, valorPredeterminado) ?: valorPredeterminado
        //sharedPreferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE)
        //USAR EN PRUEBAS
        /*val idiomaRecuperado = sharedPreferences.getString(preferencia, valorPredeterminado) ?: valorPredeterminado
        val text = "El idioma recuperado es: $idiomaRecuperado"
        val toast = Toast.makeText(this, text,  Toast.LENGTH_LONG) // in Activity
        toast.show()*/
        //USAR EN PRUEBAS
    }

    fun checkMusicStatus(){
        val musicValue: Int = getMusicStatus(1)
        if(musicValue == 1){
            changeMusicStatus(0)
            setAndSaveMusicImage("ygmute")
            return
        }
        changeMusicStatus(1)
        setAndSaveMusicImage("ygvolume")
        return
    }

    fun changeMusicStatus(value: Int){
        val editor = preferences.edit()
        editor.putInt(Preferences.MUSIC, value)// Guarda al valor seleccionado por el usuario 1 o 0
        editor.apply() // Guarda los cambios
        //USAR EN PRUEBAS
        /*val text = "El Value de Music Fue Cambiado A: $value"
        val toast = Toast.makeText(context, text,  Toast.LENGTH_SHORT) // in Activity
        toast.show()*/
        //USAR EN PRUEBAS
    }
    private fun setAndSaveMusicImage(musicImg: String){
        val editor = preferences.edit()
        editor.putString(Preferences.MUSICIMG, musicImg)
        editor.apply()
        val imgName = preferences.getString(Preferences.MUSICIMG, musicImg)// Recuperar el nombre de la imagen desde SharedPreferences
        if (!imgName.isNullOrEmpty()) {                                                                         //Verificar si se obtuvo el nombre de la imagen
            val resourceId = resources.getIdentifier(imgName, "drawable", context?.packageName)// Cargar la imagen utilizando el nombre de la imagen almacenada
            binding.ivMusic?.setImageResource(resourceId) //Cambia la imagen al momento de activar/desactivar
        }
        /*val text = "La imagen de Music Fue Cambiada A: $musicImg"
        val toast = Toast.makeText(context, text,  Toast.LENGTH_SHORT) // in Activity
        toast.show()*/
    }

    fun getSoundsStatus(valorPredeterminado: Int): Int {
        return preferences.getInt(Preferences.SOUNDS, valorPredeterminado) ?: valorPredeterminado
        //sharedPreferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE)
        //FOR TEST ONLY
        /*val idiomaRecuperado = sharedPreferences.getString(preferencia, valorPredeterminado) ?: valorPredeterminado
        val text = "El idioma recuperado es: $idiomaRecuperado"
        val toast = Toast.makeText(this, text,  Toast.LENGTH_LONG) // in Activity
        toast.show()*/
        //FOR TEST ONLY
    }

    fun checkSoundsStatus(){
        //ChangeLanguage
        val soundsValue: Int = getSoundsStatus(1)
        if(soundsValue == 1){
            changeSoundsStatus(0)
            setAndSaveSoundsImage("ygmute")
            return
        }
        changeSoundsStatus(1)
        setAndSaveSoundsImage("ygvolume")
    }

    fun changeSoundsStatus(value: Int ){
        val editor = preferences.edit()
        editor.putInt(Preferences.SOUNDS, value)// Cambia la imagen dependiendo si el sonido esta habilitado/deshabilitado
        editor.apply() // Guarda los cambios
        //FOR TEST ONLY
        // val text = "El Value de Sounds Fue Cambiado A: $value"
        // val toast = Toast.makeText(context, text,  Toast.LENGTH_SHORT) // in Activity
        // toast.show()
        //FOR TEST ONLY
    }

    private fun setAndSaveSoundsImage(soundsImg: String){
        val editor = preferences.edit()
        editor.putString(Preferences.SOUNDSIMG, soundsImg)
        editor.apply()
        val imgName = preferences.getString(Preferences.SOUNDSIMG, soundsImg)// Recuperar el nombre de la imagen desde SharedPreferences
        if (!imgName.isNullOrEmpty()) {                                                                         //Verificar si se obtuvo el nombre de la imagen
            val resourceId = resources.getIdentifier(imgName, "drawable", context?.packageName)// Cargar la imagen utilizando el nombre de la imagen almacenada
            binding.ivSounds?.setImageResource(resourceId) //Cambia la imagen al momento de activar/desactivar
        }
        /*val text = "La imagen de Sound Fue Cambiada A: $soundImg" //FOR TEST ONLY
        val toast = Toast.makeText(context, text,  Toast.LENGTH_SHORT) // in Activity
        toast.show()*///FOR TEST ONLY
    }
    fun getSoundsImage(valorPredeterminado: String): String {
        return preferences.getString(Preferences.SOUNDSIMG, valorPredeterminado) ?: valorPredeterminado
        /*val savedsimg = preferences.getInt(Preferences.SOUNDSIMG, valorPredeterminado) ?: valorPredeterminado
        val text = "La imagen de de Sound es: $savedsimg"
        val toast = Toast.makeText(context, text,  Toast.LENGTH_SHORT) // in Activity
        toast.show()*/
    }
    fun getMusicImage(valorPredeterminado: String): String {
        return preferences.getString(Preferences.MUSICIMG, valorPredeterminado) ?: valorPredeterminado
        /*val savedmimg= preferences.getInt(Preferences.MUSICIMG, valorPredeterminado) ?: valorPredeterminado
        val text = "La imagen de Music es: $savedmimg"
        val toast = Toast.makeText(context, text,  Toast.LENGTH_SHORT) // in Activity
        toast.show()*/
    }
    fun setSavedImages(){
        val savedsImage = getSoundsImage("ygvolume")
        val savedmImage = getMusicImage("ygvolume")
        if (!savedmImage.isNullOrEmpty()) {
            val resourceId = resources.getIdentifier(savedsImage, "drawable", context?.packageName) // Cargar la imagen utilizando el nombre de la imagen almacenada
            binding.ivSounds?.setImageResource(resourceId) //Cambia la imagen al momento de activar/desactivar
        }
        //Verificar si se obtuvo el nombre de la imagen
        if (!savedmImage.isNullOrEmpty()) {
            val resourceId = resources.getIdentifier(savedmImage, "drawable", context?.packageName) // Cargar la imagen utilizando el nombre de la imagen almacenada
            binding.ivMusic?.setImageResource(resourceId) //Cambia la imagen al momento de activar/desactivar
        }
    }
    private fun restartActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        activity?.finish()
    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.navHostFragment,fragment)
        fragmentTransaction.commit()
    }
}