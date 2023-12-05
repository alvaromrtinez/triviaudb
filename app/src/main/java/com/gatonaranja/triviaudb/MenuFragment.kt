package com.gatonaranja.triviaudb

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.gatonaranja.triviaudb.databinding.FragmentMenuBinding
import com.gatonaranja.triviaudb.databinding.DialogInstructionsBinding
import com.gatonaranja.triviaudb.databinding.DialogInfoBinding

class MenuFragment : Fragment() {
    private var _binding:FragmentMenuBinding? = null
    private lateinit var infoDialogBinding: DialogInfoBinding
    private lateinit var instructionsDialogBinding: DialogInstructionsBinding
    private lateinit var preferences: SharedPreferences
    private lateinit var savedLanguage: String
    private var infoDialog: AlertDialog? = null
    private var instructionsDialog: AlertDialog? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        preferences = activity?.getSharedPreferences(Preferences.DATA, Context.MODE_PRIVATE)!!
        try {
            savedLanguage = getLanguage("es")
        } catch (e: Exception) {
            e.printStackTrace()
            val text = "NO SE RECUPERO EL IDIOMA"
            val toast = Toast.makeText(context, text,  Toast.LENGTH_LONG) // in Activity
            toast.show()
        }
        return binding.root

        //TEST ONLY
    // Crea un botón y configúralo
    /*  val crashButton = Button(requireContext())
       crashButton.text = "Test Crash"
       crashButton.setOnClickListener {
           throw RuntimeException("Test Crash") // Forzar un error
       }
       // Agrega el botón al contenedor de vistas
       binding.linearLayout.addView(crashButton, ViewGroup.LayoutParams(
           ViewGroup.LayoutParams.MATCH_PARENT,
           ViewGroup.LayoutParams.WRAP_CONTENT
       ))*/
        //TEST ONLY

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeTitleImage(savedLanguage)
        changeButtonsImages(savedLanguage )
        createCustomDialog()
        createInstructionsDialog()
        binding.ivConfig.setOnClickListener(){
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToConfigFragment())
            //replaceFragment(ConfigFragment())
        }
        //PROXIMAMENTE DISPONIBLE
        /*binding.btnSmg.setOnClickListener(){
            val intent = Intent(activity, StoryModeMenu::class.java)
            startActivity(intent)
            activity?.finish()
        }*/
        binding.btnAg.setOnClickListener{
            val intentR = Intent(activity, RandomQuizMode::class.java)
            startActivity(intentR)
            activity?.finish()
        }
        binding.ivRecords.setOnClickListener(){
            //replaceFragment(ConfigFragment())
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToStatsFragment())
        }
        binding.ivInfo.setOnClickListener(){
            showInfoDialog()
        }

        binding.btnHowtoplay.setOnClickListener(){
            showInstructionsDialog()
        }
    }
    private fun createCustomDialog(){
        infoDialogBinding = DialogInfoBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(infoDialogBinding.getRoot())
        infoDialog= builder.create()
        // Habilita el modo inmersivo (pantalla completa) para la actividad
        fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
            AlertDialog.Builder(requireContext())
                .create()
    }
    private fun showInfoDialog(){
        if(infoDialog != null && !infoDialog!!.isShowing){
            infoDialog!!.setCanceledOnTouchOutside(false);
            infoDialog!!.show()
        }
        infoDialogBinding.closeView.setOnClickListener{
            infoDialog!!.dismiss()
        }
    }
    private fun createInstructionsDialog(){
        instructionsDialogBinding = DialogInstructionsBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(instructionsDialogBinding.getRoot())
        instructionsDialog= builder.create()
        // Habilita el modo inmersivo (pantalla completa) para la actividad
        fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
            AlertDialog.Builder(requireContext())
                .create()
    }
    private fun showInstructionsDialog(){
        if(instructionsDialog != null && !instructionsDialog!!.isShowing){
            instructionsDialog!!.setCanceledOnTouchOutside(false);
            instructionsDialog!!.show()
        }
        instructionsDialogBinding.closeView.setOnClickListener{
            instructionsDialog!!.dismiss()
        }
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
    fun changeTitleImage(savedLanguage: String){
        if(savedLanguage=="en"){
            binding.ivTitle.setImageResource(R.drawable.nutitleen)
            return
        }
        binding.ivTitle.setImageResource(R.drawable.nutitlees)
    }
    fun changeButtonsImages(savedLanguage: String){
        if(savedLanguage=="en"){
            binding.btnAg.setBackgroundResource(R.drawable.playbtnen)
            binding.btnHowtoplay.setBackgroundResource(R.drawable.instructionsbtnen)
            return
        }
        binding.btnAg.setBackgroundResource(R.drawable.playbtn)
        binding.btnHowtoplay.setBackgroundResource(R.drawable.instructionsbtn)
    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.navHostFragment,fragment)
        fragmentTransaction.commit()
    }
}