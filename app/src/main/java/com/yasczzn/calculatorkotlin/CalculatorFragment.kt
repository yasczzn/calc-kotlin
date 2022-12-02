package com.example.calculatorkotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorkotlin.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    companion object{
        fun newInstance() =
            CalculatorFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}