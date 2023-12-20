package com.gatonaranja.triviaudb

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.widget.Toast

class AudioManager(private val context: Context) {
    private lateinit var preferences: SharedPreferences
    private var mMediaPlayer: MediaPlayer? = null
    private var sMediaPlayer: MediaPlayer? = null
    private var savedMusicStatus: Int = 0
    private var savedSoundStatus: Int = 0


    init{
        preferences = context.getSharedPreferences(Preferences.DATA, Context.MODE_PRIVATE)
        try {
            savedMusicStatus = getMusicStatus(1)
        } catch (e: Exception) {
            e.printStackTrace()
            log("MUSIC", "NO SE RECUPERÓ LA CONFIGURACIÓN DE LA MÚSICA")
        }

        try {
            savedSoundStatus = getSoundsStatus(1)
        } catch (e: Exception) {
            e.printStackTrace()
            log("MUSIC", "NO SE RECUPERÓ LA CONFIGURACIÓN DEL SONIDO")
        }

    }

    fun playMusicOn(music: Int){
        if(savedMusicStatus==1){
            playMusic(music)
        }
    }

    fun playSoundOn(effectSound: Int){
        if(savedSoundStatus==1){
            playSound(effectSound)
        }
    }

    fun playMusic(music: Int){
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(context, music)
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }

    // 2. Pause playback
    fun pauseMusic() {
        if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
    }


    // 1. Plays the sound
    fun playSound(effectSound: Int) {
        if (sMediaPlayer == null) {
            sMediaPlayer = MediaPlayer.create(context, effectSound)
            sMediaPlayer!!.isLooping = false
            sMediaPlayer!!.start()
        } else sMediaPlayer!!.start()
    }

    // 3. Stops playback
    fun stopSound() {
        if (sMediaPlayer != null) {
            sMediaPlayer!!.stop()
            sMediaPlayer!!.release()
            sMediaPlayer = null
        }
    }
    // 4. Destroys the MediaPlayer instance when the app is closed
    /*fun onStop() {
       super.onStop()
       if (mMediaPlayer != null) {
           mMediaPlayer!!.release()
           mMediaPlayer = null
       }
   }*/

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
    fun getSoundsStatus(valorPredeterminado: Int): Int {
        return preferences.getInt(Preferences.SOUNDS, valorPredeterminado) ?: valorPredeterminado
        //sharedPreferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE)
        //USAR EN PRUEBAS
        /*val idiomaRecuperado = sharedPreferences.getString(preferencia, valorPredeterminado) ?: valorPredeterminado
        val text = "El idioma recuperado es: $idiomaRecuperado"
        val toast = Toast.makeText(this, text,  Toast.LENGTH_LONG) // in Activity
        toast.show()*/
        //USAR EN PRUEBAS

    }

}