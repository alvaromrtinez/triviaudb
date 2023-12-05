package com.gatonaranja.triviaudb

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gatonaranja.triviaudb.databinding.FragmentStatsBinding

class StatsFragment : Fragment() {
    private lateinit var preferences: SharedPreferences
    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = activity?.getSharedPreferences(Preferences.DATA, Context.MODE_PRIVATE)!!
        var corrects = getSavedCorrects(0)!!.toString()
        var incorrects = getSavedIncorrects(0)!!.toString()
        binding.tvCscore?.setText(corrects)
        binding.tvIscore?.setText(incorrects)
        binding.ivBack.setOnClickListener(){
            //replaceFragment(MenuFragment())
            requireActivity().onBackPressed()
        }
    }
    private fun getSavedCorrects(valorPredeterminado: Int): Int{
        return preferences.getInt(Preferences.CORRECTANSWERS, valorPredeterminado) ?: valorPredeterminado
    }
    private fun getSavedIncorrects(valorPredeterminado: Int): Int{
        return preferences.getInt(Preferences.INCORRECTANSWERS, valorPredeterminado) ?: valorPredeterminado
    }
}