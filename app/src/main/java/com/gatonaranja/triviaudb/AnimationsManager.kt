package com.gatonaranja.triviaudb

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import android.content.Context

class AnimationsManager(private val context: Context) {
    private lateinit var animationView: LottieAnimationView
    private lateinit var startTranslationYAnim: ObjectAnimator
    private lateinit var translationYAnim: ObjectAnimator
    private lateinit var lottieAnimation: ObjectAnimator
    //val animatorSet = AnimatorSet()

    fun createAnimationView(translateX: Float, animationView: LottieAnimationView) {
        // Crear un nuevo LottieAnimationView
        this.animationView = animationView
        // Configurar las propiedades del LottieAnimationView (por ejemplo, archivo de animación)
        /*// Agregar el LottieAnimationView al diseño de la clase
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        animationView.layoutParams = layoutParams*/

        // Cambiar el tamaño de la vista
        animationView.layoutParams.width = 180 // Reemplaza "nuevoAnchoEnPixeles" con el ancho deseado
        animationView.layoutParams.height = 180 // Reemplaza "nuevoAltoEnPixeles" con el alto deseado
        animationView.requestLayout() // Aplicar los cambios en el diseño
        animationView.translationX = translateX
        // Inicializar las propiedades de animación
        startTranslationYAnim = ObjectAnimator.ofFloat(animationView, "translationY", 0f)
        translationYAnim = ObjectAnimator.ofFloat(animationView, "translationY", 0f)
        lottieAnimation = ObjectAnimator.ofFloat(animationView, "progress", 0f, 0f)
    }


    fun playHappyAnimation(correctOption: TextView, animation:Int){
        this.animationView = animationView
        val correctOptionY = correctOption.y + 150f // Obtén la posición vertical de la vista de opción correcta
        val finalY = correctOptionY - 300f // Calcula la posición final para la vista de Lottie
        cancelAnimation()// Cancel any previous animation
        //Declaring animations
        startTranslationYAnim = ObjectAnimator.ofFloat(animationView, "translationY", correctOptionY)// Crear una animación para la posición inicial
        translationYAnim = ObjectAnimator.ofFloat(animationView, "translationY", finalY) // Crea una animación de translación para mover la vista de Lottie
        lottieAnimation = ObjectAnimator.ofFloat(animationView, "progress", 0f, 15f) // Crea una animación de Lottie para reproducir el JSON.

        startTranslationYAnim.duration = 0 // Sin duración para la posición inicial
        translationYAnim.duration = 500    // Configura la duración de ambas animaciones
        lottieAnimation.duration = 4000
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(startTranslationYAnim/*translationYAnim*/) // animatorSet = AnimatorSet()// Crea un AnimatorSet para ejecutar ambas animaciones en paralelo
        animatorSet.playTogether(lottieAnimation)

        animationView.setAnimation(animation) // Reemplaza con tu archivo de animación
        animationView.visibility = View.VISIBLE // Asegúrate de que la vista de Lottie sea visible
        animatorSet.start()// Inicia el AnimatorSet
        val delayMillis: Long = 1000    // Crea un nuevo objeto Handler
        val handler = Handler()         // Postea un Runnable después del retardo
        handler.postDelayed({           // Crea y muestra el AlertDialog después del retardo
            fadeOutAnimation(animationView)
            animationView.visibility = View.INVISIBLE
        }, delayMillis)
    }

    fun playSadAnimation(correctOption: TextView, animation:Int){
        this.animationView = animationView
        val correctOptionY = correctOption.y + 150f // Obtén la posición vertical de la vista de opción correcta
        val finalY = correctOptionY - 30f // Calcula la posición final para la vista de Lottie
        cancelAnimation()// Cancel any previous animation
        //Declaring animations
        startTranslationYAnim = ObjectAnimator.ofFloat(animationView, "translationY", correctOptionY)// Crear una animación para la posición inicial
        translationYAnim = ObjectAnimator.ofFloat(animationView, "translationY", finalY) // Crea una animación de translación para mover la vista de Lottie
        lottieAnimation = ObjectAnimator.ofFloat(animationView, "progress", 0f, 15f) // Crea una animación de Lottie para reproducir el JSON.

        startTranslationYAnim.duration = 0 // Sin duración para la posición inicial
        translationYAnim.duration = 500    // Configura la duración de ambas animaciones
        lottieAnimation.duration = 6000
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(startTranslationYAnim,translationYAnim) // animatorSet = AnimatorSet()// Crea un AnimatorSet para ejecutar ambas animaciones en paralelo
        animatorSet.playTogether(lottieAnimation)

        animationView.setAnimation(animation) // Reemplaza con tu archivo de animación
        animationView.visibility = View.VISIBLE // Asegúrate de que la vista de Lottie sea visible
        animatorSet.start()// Inicia el AnimatorSet
        //animatorSet.pause()
        val delayMillis: Long = 1000    // Crea un nuevo objeto Handler
        val handler = Handler()         // Postea un Runnable después del retardo
        handler.postDelayed({           // Crea y muestra el AlertDialog después del retardo
            fadeOutAnimation(animationView)
            animationView.visibility = View.INVISIBLE
        }, delayMillis)
        hideView(animatorSet)
    }

    private fun hideView(animatorSet: AnimatorSet){
        if(animatorSet.isPaused) {
            animationView.visibility = View.INVISIBLE
        }
    }

    private fun fadeOutAnimation(animationView: LottieAnimationView){
        val animation = AnimationUtils.loadAnimation(context, R.anim.fade_out)//loading our custom made animations
        animationView.startAnimation(animation)//starting the animation
    }
    fun cancelAnimation(){
        // Cancelar las animaciones anteriores
        startTranslationYAnim.cancel()
        translationYAnim.cancel()
        lottieAnimation.cancel()
    }
}