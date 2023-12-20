package com.gatonaranja.triviaudb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.gatonaranja.triviaudb.databinding.ActivityRandomQuizModeBinding
import com.gatonaranja.triviaudb.databinding.DialogFeedbackBinding
import com.gatonaranja.triviaudb.databinding.DialogBacktomenuBinding
import com.gatonaranja.triviaudb.databinding.DialogPauseBinding
import com.google.android.gms.ads.interstitial.InterstitialAd
import java.util.Locale

class RandomQuizMode : AppCompatActivity() {

    private lateinit var binding: ActivityRandomQuizModeBinding
    private lateinit var feedbackBinding: DialogFeedbackBinding
    private lateinit var backtoMenuBinding: DialogBacktomenuBinding
    private lateinit var pauseBinding: DialogPauseBinding
    private var tvCuentaAtras: TextView? = null
    private lateinit var timer: CountDownTimer
    private var cronometroFuncion: Int = 0
    private var pSelectedOption: Int = 0
    // private var mSelectedOptionPosition: Int = 0
    private var isTimerRunning: Boolean = false
    private lateinit var tvQuestion : TextView
    private lateinit var option1: TextView
    private lateinit var option2: TextView
    private lateinit var option3: TextView
    private lateinit var option4: TextView
    private lateinit var buttonMenu: Button
    private lateinit var buttonContinue: Button

    var tvCorrectas: TextView? = null
    var tvIncorrectas: TextView? = null
    var tvFeed: TextView? = null
    var closeView: ImageView? = null

    private var textColorDefaultCd: ColorStateList? = null
    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "RandomModeQuiz"
    private lateinit var interstitialAdManager: InterstitialAdManager
    private lateinit var audioManager: AudioManager
    /*private lateinit var animationManager: AnimationsManager
    private lateinit var animationView: LottieAnimationView*/
    private var respuestas: AlertDialog? = null
    private var backtoMenuDialog: AlertDialog? = null
    private var pauseDialog: AlertDialog? = null
    private lateinit var preferences: SharedPreferences
    private lateinit var savedLanguage: String
    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState)
        binding = ActivityRandomQuizModeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        createAlertDialog()
        createBtmDialog()
        createPauseDialog()
        fullScreenMode()
        preferences = getSharedPreferences(Preferences.DATA, Context.MODE_PRIVATE)
        try {
            savedLanguage = getLanguage("es")
        } catch (e: Exception) {
            e.printStackTrace()
            log("LANGUAGE", "NO SE RECUPERO EL IDIOMA")
        }
        setAppLocale()
        changeButtonsImages(savedLanguage)
        tvQuestion = findViewById(R.id.tv_question)
        option1 = findViewById(R.id.tv_option_one)
        option2 = findViewById(R.id.tv_option_two)
        option3 = findViewById(R.id.tv_option_three)
        option4 = findViewById(R.id.tv_option_four)

        tvCuentaAtras = findViewById(R.id.tvCuentaAtras)
        tvCorrectas = findViewById(R.id.tv_correctas)
        tvIncorrectas = findViewById(R.id.tv_incorrectas)

        textColorDefaultCd = tvCuentaAtras?.getTextColors();
        var mQuestionsList: ArrayList<Question>? = Questions.getQuestions(this)
        var randomIndexes: List<Int>
        var ArraySize : Int = 50
        randomIndexes = (0 until 61).toList().shuffled()
        var posInRandomsArray: Int = 0
        var randomIndex = randomIndexes[posInRandomsArray]
        var question = mQuestionsList!!.get(randomIndex)
        var  mCorrectAnswers: Int = 0
        var mIncorrectAnswers: Int = 0
        //var timerStatus: Int = 0
        questionProcess(mQuestionsList, randomIndexes, ArraySize, posInRandomsArray, randomIndex,question, mCorrectAnswers, mIncorrectAnswers)
        //buttonMenu = feedbackBinding.btnMenu
        buttonContinue = feedbackBinding.btnContinue
        audioManager = AudioManager(this)
        audioManager.playMusicOn(R.raw.appmusicbg)
        /*animationView = binding.happyanimation
        animationManager = AnimationsManager(this)
        animationManager.createAnimationView(750f, animationView)*/
        interstitialAdManager = InterstitialAdManager(this)
        //USAR EN PRUEBAS
        /* binding.btnNRandom.setOnClickListener(){
              i++
              indiceAleatorio = indicesAleatorios[i]
              //mCurrentIndex++
              binding.tvId.text=("indicesAleatorios"+ "| "+i.toString()+ " |")
              */
        //USAR EN PRUEBAS
    }
    override fun onPause() {
        super.onPause()
        audioManager.pauseMusic()
       /*  val toast = Toast.makeText(this, "¡La actividad esta en pausa!",  Toast.LENGTH_LONG)
         toast.show()*/
    }
    override fun onResume() {
        super.onResume()
        audioManager.playMusicOn(R.raw.appmusicbg)
        //Recuperar el array de numeros aleatorios.
        //Recuperar la posición actual de la pregunta (o feedback).
        //showFeedback()
        /*val toast = Toast.makeText(this, "¡La actividad esta en resumen!",  Toast.LENGTH_LONG)
        toast.show()*/
    }

    override fun onStop() {
        super.onStop()
        //timer?.cancel()
       /* val toast = Toast.makeText(this, "Activity onStop()",  Toast.LENGTH_LONG)
        toast.show()*/
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
            backtoMenuBinding.btnYes.setBackgroundResource(R.drawable.backbtnen)
            backtoMenuBinding.btnCancel.setBackgroundResource(R.drawable.cancelbtnen)
            feedbackBinding.btnContinue.setBackgroundResource(R.drawable.continuebtnen)
            pauseBinding.btnResume.setBackgroundResource(R.drawable.resumebtnen)
            return
        }
        backtoMenuBinding.btnYes.setBackgroundResource(R.drawable.backbtn)
        backtoMenuBinding.btnCancel.setBackgroundResource(R.drawable.cancelbtn)
        feedbackBinding.btnContinue.setBackgroundResource(R.drawable.continuebtn)
        pauseBinding.btnResume.setBackgroundResource(R.drawable.resumebtnes)
    }

    fun fullScreenMode(){
        // Habilita el modo inmersivo (pantalla completa) para la actividad
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
    }

    private fun questionProcess(pQuestionList: ArrayList<Question>?, pRandomIndexes: List<Int>,pArraySize: Int,pPosInRandomsArray: Int, pRandomIndex: Int, pQuestion: Question ,pCorrectAnswers: Int, pIncorrectAnswers: Int){
        changeBtnStatus(false,false,false,false)
        setAndDisplayQuestion(pQuestion)
        startTimer(pQuestionList, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion,pCorrectAnswers, pIncorrectAnswers)
        viewClicked(pQuestionList, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion,pCorrectAnswers, pIncorrectAnswers)
        binding.ivBack.setOnClickListener(){
            showBacktomenuDialog(pQuestionList, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex,pQuestion, pCorrectAnswers, pIncorrectAnswers)
        }
        binding.ivPause.setOnClickListener(){
            showPauseDialog(pQuestionList, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex,pQuestion, pCorrectAnswers, pIncorrectAnswers)
        }
    }
    private fun setAndDisplayQuestion(pQuestion: Question) {
        //pQuestionsList: ArrayList<Question>? = questionArray
        //prandomIndexes = randomIndexes
        //pPosInRandomsArray: Int = 0
        //var mCurrentPosition: Int = 1
        defaultOptionsView()
        tvQuestion.text = pQuestion.question
        option1.text = pQuestion.optionOne
        option2.text = pQuestion.optionTwo
        option3.text = pQuestion.optionThree
        option4.text = pQuestion.optionFour
        // Agrega un retardo de 2000 milisegundos (2 segundos)
        val delayMillis: Long = 1000    // Crea un nuevo objeto Handler
        val handler = Handler()         // Postea un Runnable después del retardo
        handler.postDelayed({
            changeBtnStatus(true, true, true, true)// Crea y muestra la pregunta después del retardo
        }, delayMillis)
    }

    private fun startTimer(pQuestionList: ArrayList<Question>?, pRandomIndexes: List<Int>,pArraySize: Int,pPosInRandomsArray: Int, pRandomIndex: Int, pQuestion: Question, pCorrectAnswers: Int, pIncorrectAnswers: Int){
        if (!isTimerRunning) {
            timer = object : CountDownTimer(31000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    cronometroFuncion = 0
                    cronometroFuncion = millisUntilFinished.toInt()
                    tvCuentaAtras?.setText("" + cronometroFuncion / 1000)
                    if (cronometroFuncion < 10000) {
                        tvCuentaAtras?.setTextColor(Color.RED);
                    } else {
                        tvCuentaAtras?.setTextColor(textColorDefaultCd);
                    }
                }
                override fun onFinish()  {
                    tvCuentaAtras?.setText("0")
                    onSelectedOption(pQuestionList, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, 0,pCorrectAnswers, pIncorrectAnswers)
                }
            }.start()
            isTimerRunning = true
        }
        /*val toast = Toast.makeText(this, "Timer iniciado",  Toast.LENGTH_LONG)
        toast.show()*/
    }
    fun viewClicked(pQuestionArray: ArrayList<Question>?, pRandomIndexes: List<Int>,pArraySize: Int,pPosInRandomsArray: Int, pRandomIndex: Int, pQuestion: Question, pCorrectAnswers: Int, pIncorrectAnswers: Int){
        binding.tvOptionOne.setOnClickListener {
            onSelectedOption(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, 1, pCorrectAnswers, pIncorrectAnswers)
        }
        binding.tvOptionTwo.setOnClickListener {
            onSelectedOption(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, 2, pCorrectAnswers, pIncorrectAnswers)
        }
        binding.tvOptionThree.setOnClickListener {
            onSelectedOption(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, 3, pCorrectAnswers, pIncorrectAnswers)
        }
        binding.tvOptionFour.setOnClickListener{
            onSelectedOption(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, 4, pCorrectAnswers, pIncorrectAnswers)
        }
    }
    private fun onSelectedOption(pQuestionArray: ArrayList<Question>?, pRandomIndexes: List<Int>,pArraySize: Int,pPosInRandomsArray: Int, pRandomIndex: Int, pQuestion: Question, pSelectedOptionNum:Int, pCorrectAnswers: Int, pIncorrectAnswers: Int){
        //TEST ONLY
       /* binding.tvList.text = pRandomIndexes.toString()
        binding.tvRNumber.text = "Numero aleatorio actual: "+ pRandomIndex.toString()
        //LA LINEA INFERIOR ES PARA VER LA POSICION ACTUAL DEL ARREGLO DE ALEATORIOS
        binding.tvId.text=("indicesAleatorios"+ "| "+pPosInRandomsArray.toString()+ " |")*/
        //TEST ONLY
        // timer?.cancel()
        /*val toast = Toast.makeText(this, "IN ON SELECTEDOPTION FUNCTION",  Toast.LENGTH_LONG)
        toast.show()*/
        cancelTimer()
        changeBtnStatus(false,false,false,false)
        checkAnswer(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex, pQuestion, pSelectedOptionNum, pCorrectAnswers, pIncorrectAnswers)
    }

    private fun cancelTimer(){
        if (isTimerRunning) {
            timer.cancel()
            isTimerRunning = false
        }
        /* val toast = Toast.makeText(this, "Timer cancelado",  Toast.LENGTH_LONG)
         toast.show()*/
    }

    private fun checkAnswer(pQuestionArray: ArrayList<Question>?, pRandomIndexes: List<Int>,pArraySize: Int,pPosInRandomsArray: Int, pRandomIndex: Int, pQuestion: Question, pSelectedOptionNum:Int, pCorrectAnswers: Int, pIncorrectAnswers: Int) {
        var pCorrectAnswers = pCorrectAnswers
        var pIncorrectAnswers = pIncorrectAnswers
        //val selectedOptionTv = placeAnimation(pSelectedOptionNum)
        //animationManager.setAnimation()

        if(pSelectedOptionNum==0){
            pIncorrectAnswers++
            //animationManager.playSadAnimation(selectedOptionTv, R.raw.sademoji)
            audioManager.playSoundOn(R.raw.wronganswersound)
            applyDelay(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, pCorrectAnswers,pIncorrectAnswers)
            return //El flujo sigue hacia el método anterior ya que su llamado fue antes de este return.
        }
        if (pQuestion!!.correctAnswer != pSelectedOptionNum) {
            answerView(pSelectedOptionNum, R.drawable.wrong_option_border_bg)
            answerView(pQuestion.correctAnswer, R.drawable.correct_option_border_bg)
            pIncorrectAnswers++
            //animationManager.playHappyAnimation(selectedOptionTv, R.raw.sademoji)
            audioManager.playSoundOn(R.raw.wronganswersound)
            applyDelay(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, pCorrectAnswers,pIncorrectAnswers)
        } else {
            pCorrectAnswers++
            answerView(pQuestion.correctAnswer, R.drawable.correct_option_border_bg)
            //animationManager.playSadAnimation(selectedOptionTv, R.raw.happyemoji)
            audioManager.playSoundOn(R.raw.correctanswersound)
            applyDelay(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, pCorrectAnswers,pIncorrectAnswers)
        }
    }
    fun changeBtnStatus(option1Ena: Boolean, option2Ena: Boolean,option3Ena: Boolean,option4Ena: Boolean){
        option1.isEnabled = option1Ena
        option2.isEnabled = option2Ena
        option3.isEnabled = option3Ena
        option4.isEnabled = option4Ena
    }

    fun applyDelay(pQuestionArray: ArrayList<Question>?, pRandomIndexes: List<Int>,pArraySize: Int,pPosInRandomsArray: Int, pRandomIndex: Int, pQuestion: Question, pCorrectAnswers: Int, pIncorrectAnswers: Int){
        // Agrega un retardo de 2000 milisegundos (2 segundos)
        // Asegúrate de que la vista de Lottie sea visible
        disableFeedbackButtons(false)
        val delayMillis: Long = 1500    // Crea un nuevo objeto Handler
        val handler = Handler()         // Postea un Runnable después del retardo
        handler.postDelayed({           // Crea y muestra el AlertDialog después del retardo
            showFeedbackDialog(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, pCorrectAnswers,pIncorrectAnswers)
            checkCounter(pPosInRandomsArray)
        }, delayMillis)
    }
    fun createAlertDialog(){
        feedbackBinding = DialogFeedbackBinding.inflate(layoutInflater)
        feedbackBinding.tvAnswer.text = "Respuesta" // Set text to TextView
        val builder = AlertDialog.Builder(this@RandomQuizMode)
        builder.setView(feedbackBinding.getRoot())
        respuestas = builder.create()
        respuestas!!.getWindow()!!.getAttributes()!!.windowAnimations = R.style.anim1; //style id
        respuestas!!.setCanceledOnTouchOutside(false);
        respuestas!!.setOnKeyListener { _, keyCode, _ ->
            keyCode == KeyEvent.KEYCODE_BACK  }
    }

    fun showFeedbackDialog(pQuestionArray: ArrayList<Question>?, pRandomIndexes: List<Int>,pArraySize: Int,pPosInRandomsArray: Int, pRandomIndex: Int, pQuestion: Question, pCorrectAnswers: Int, pIncorrectAnswers: Int){
        audioManager.stopSound()
        respuestas!!.show()
        feedbackBinding.tvFeed?.text = pQuestion.feedback
        feedbackBinding.closeView.setOnClickListener{
            hideDialog()
            nextQuestion(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, pCorrectAnswers, pIncorrectAnswers)
        }
        feedbackBinding.btnContinue.setOnClickListener {
            hideDialog()
            nextQuestion(pQuestionArray, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion, pCorrectAnswers, pIncorrectAnswers)
        }
        val delayMillis: Long = 1000    // Crea un nuevo objeto Handler
        val handler = Handler()         // Postea un Runnable después del retardo
        handler.postDelayed({
            disableFeedbackButtons(true)// Crea y muestra la pregunta después del retardo
        }, delayMillis)
    }
    fun createBtmDialog(){
        backtoMenuBinding = DialogBacktomenuBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(this@RandomQuizMode)
        builder.setView(backtoMenuBinding.getRoot())
        backtoMenuDialog = builder.create()
        backtoMenuDialog!!.getWindow()!!.getAttributes()!!.windowAnimations = R.style.anim1; //style id
        backtoMenuDialog!!.setCanceledOnTouchOutside(false);
        backtoMenuDialog!!.setOnKeyListener { _, keyCode, _ ->
            keyCode == KeyEvent.KEYCODE_BACK
        }
    }

    fun showBacktomenuDialog(pQuestionList: ArrayList<Question>?, pRandomIndexes: List<Int>,pArraySize: Int,pPosInRandomsArray: Int, pRandomIndex: Int, pQuestion: Question, pCorrectAnswers: Int, pIncorrectAnswers: Int){
        cancelTimer()
        audioManager.pauseMusic()
        backtoMenuDialog!!.show()
        backtoMenuBinding.btnYes.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        backtoMenuBinding.btnCancel.setOnClickListener{
            hideBtmDialog()
            audioManager.playMusicOn(R.raw.appmusicbg)
            startTimer(pQuestionList, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion,pCorrectAnswers, pIncorrectAnswers)
        }
    }

    fun createPauseDialog(){
        pauseBinding = DialogPauseBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(this@RandomQuizMode)
        builder.setView(pauseBinding.getRoot())
       pauseDialog = builder.create()
       pauseDialog!!.getWindow()!!.getAttributes()!!.windowAnimations = R.style.anim1; //style id
       pauseDialog!!.setCanceledOnTouchOutside(false);
       pauseDialog!!.setOnKeyListener { _, keyCode, _ ->
            keyCode == KeyEvent.KEYCODE_BACK
        }
    }

    fun showPauseDialog(pQuestionList: ArrayList<Question>?, pRandomIndexes: List<Int>,pArraySize: Int,pPosInRandomsArray: Int, pRandomIndex: Int, pQuestion: Question, pCorrectAnswers: Int, pIncorrectAnswers: Int){
        cancelTimer()
        audioManager.pauseMusic()
        pauseDialog!!.show()
        pauseBinding.btnResume.setOnClickListener{
            hidePauseDialog()
            audioManager.playMusicOn(R.raw.appmusicbg)
            startTimer(pQuestionList, pRandomIndexes, pArraySize, pPosInRandomsArray, pRandomIndex ,pQuestion,pCorrectAnswers, pIncorrectAnswers)
        }
    }
    fun showAlertDialog(){
        if (!respuestas!!.isShowing) {
            // Muestra el AlertDialog solo si no está en pantalla
            respuestas!!.show()
        }
    }
    fun hideDialog(){
        if (respuestas!!.isShowing) {
            respuestas!!.dismiss() // Oculta el AlertDialog si está en pantalla
        }
    }
    fun showBtmDialog(){
        if (!backtoMenuDialog!!.isShowing) {
            // Muestra el AlertDialog solo si no está en pantalla
            backtoMenuDialog!!.show()
        }
    }
    fun hideBtmDialog(){
        if (backtoMenuDialog!!.isShowing) {
            backtoMenuDialog!!.dismiss() // Oculta el AlertDialog si está en pantalla
        }
    }

    fun hidePauseDialog(){
        if (pauseDialog!!.isShowing) {
            pauseDialog!!.dismiss() // Oculta el AlertDialog si está en pantalla
        }
    }

    fun disableFeedbackButtons(btnContinue: Boolean){
        buttonContinue.isEnabled = btnContinue
    }

    private fun restartFeedbackDialog(){
        respuestas?.dismiss() // Esto cerrará el AlertDialog si no es nulo
        //showFeedback()
    }
    private fun nextQuestion(pQuestionArray: ArrayList<Question>?, pRandomIndexes: List<Int>,pArraySize: Int,pPosInRandomsArray: Int, pRandomIndex: Int, pNextQuestion: Question, pCorrectAnswers: Int, pIncorrectAnswers: Int){
        if (pPosInRandomsArray == pArraySize-1) {
            showResults(pCorrectAnswers,pIncorrectAnswers)
        } else {
            var pNextPosInRandomsArray = pPosInRandomsArray+1
            var pNextRandomIndex= pRandomIndexes[pNextPosInRandomsArray]
            var pNextQuestion = pQuestionArray!!.get(pNextRandomIndex)
            questionProcess(pQuestionArray, pRandomIndexes, pArraySize, pNextPosInRandomsArray, pNextRandomIndex,pNextQuestion,pCorrectAnswers, pIncorrectAnswers)
        }
        //TEST ONLY
        // SOLO SE NECESITA LA LINEA DE ABAJO PARA VER LA POSICION DE LA PREGUNTA
       /* binding.tvId.text=("indicesAleatorios"+ "| "+pPosInRandomsArray.toString()+ " |")
        binding.tvRNumber.text = ("Numero aleatorio actual: "+ pRandomIndex.toString())*/
        //TEST ONLY


    }
    fun showResults(pCorrectAnswers: Int, pIncorrectAnswers: Int) {
        val intent = Intent(this, Results::class.java)
        intent.putExtra("correctas",pCorrectAnswers.toString())
        intent.putExtra("incorrectas",pIncorrectAnswers.toString())
        startActivity(intent)
        finish()
    }

    fun placeAnimation(pSelectedOption: Int): TextView {
        var optionSelected: TextView
        optionSelected = binding.tvOptionOne

        if (pSelectedOption == 1) {
            optionSelected = binding.tvOptionOne
            return optionSelected
        }
        if (pSelectedOption == 2) {
            optionSelected = binding.tvOptionTwo
            return optionSelected
        }
        if (pSelectedOption == 3) {
            optionSelected = binding.tvOptionThree
            return optionSelected
        }
        if (pSelectedOption == 4) {
            optionSelected = binding.tvOptionFour
            return optionSelected
        }
        return optionSelected
    }


    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, option1)
        options.add(1, option2)
        options.add(2, option3)
        options.add(3, option4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#FFFAF0"))
            option.typeface = Typeface.DEFAULT_BOLD
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }
    private fun selectedOptionView(
        tv: TextView,
        selectedOptionNum: Int
    ) {
        defaultOptionsView()
        // mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.default_option_border_bg
        )
    }
    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                option1.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                option2.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                option3.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                option4.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
    private fun loadAd() {
        interstitialAdManager.initAds()     // Llamada para cargar el anuncio
    }

    private fun showAd() {
        interstitialAdManager.showAds()     // Llamada para mostrar el anuncio
    }
    private fun checkCounter(pPosInRandomsArray: Int){
        var count: Int
        count=1 //16 & 33 & 49
        if(pPosInRandomsArray == 16 || pPosInRandomsArray == 33 || pPosInRandomsArray == 49){
            disableFeedbackButtons(false)
            if(count<=3){
                disableFeedbackButtons(true)
                //val delayMillis: Long = 3000
                //val handler = Handler()// Crea un nuevo objeto Handler
                hideDialog()
                showAd()
                loadAd()
                count+=1// Crea y muestra el Anuncion después del retardo
                showAlertDialog()
                /*handler.postDelayed({// Postea un Runnable después del retardo
                }, delayMillis)*/
            }
        }
    }
}