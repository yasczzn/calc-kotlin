package com.yasczzn.calculatorkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yasczzn.calculatorkotlin.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentCalculatorBinding = FragmentCalculatorBinding.inflate(layoutInflater)
        return binding.root



    }

    companion object{
        fun newInstance() =
            CalculatorFragment()
    }

}