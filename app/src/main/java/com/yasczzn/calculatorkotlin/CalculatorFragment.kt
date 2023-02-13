package com.yasczzn.calculatorkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.yasczzn.calculatorkotlin.databinding.FragmentCalculatorBinding
import kotlinx.android.synthetic.main.fragment_calculator.*

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!
    private var canAddOpr = false
    private var canAddDecimal = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculatorBinding.inflate(layoutInflater)
        return binding.root

        binding.

    }

    fun numberAct(view: View) {
        if (view is Button) {
            if (view.text == ".") {
                if (canAddDecimal)
                    tv_opr.append(view.text)
                canAddDecimal = false
            } else
            tv_opr.append(view.text)
            canAddOpr = true
        }
    }

    fun oprAct(view: View) {
        if (view is Button && canAddOpr) {
            tv_opr.append(view.text)
            canAddOpr = false
            canAddDecimal = true
        }
    }

    fun clearAllAct(view: View) {
        tv_opr.text = ""
        tv_result.text = ""
    }

    fun eraseAct(view: View) {
        val length = tv_opr.length()
        if(length > 0)
            tv_opr.text = tv_opr.text.subSequence(0, length - 1)
    }

    fun equalAct(view: View) {
        tv_result.text = calculateResult()
    }

    private fun calculateResult(): String {
        val digitsOpr = digitsOpr()
        if (digitsOpr.isEmpty())
            return  ""

        val timesDiv = timesDivisionCalculate(digitsOpr)
        if (timesDiv.isEmpty())
            return  ""

        val result = addSubstractCalculate(timesDiv)
        return result.toString()
    }

    private fun addSubstractCalculate(passedList: MutableList<Any>): Float {
        var result = passedList[0] as Float

        for (i in passedList.indices) {
            if (passedList[i] is Char && i != passedList.lastIndex) {
                val operator = passedList[i]
                val nextDigit = passedList[i + 1] as Float
                if (operator == '+')
                    result += nextDigit
                if (operator == '-')
                    result -= nextDigit
            }
        }

        return result
    }

    private fun timesDivisionCalculate(passedList: MutableList<Any>): MutableList<Any> {
        var list = passedList
        while (list.contains('x') || list.contains('÷')) {
            list = calcTimesDiv(list)
        }
        return  list
    }

    private fun calcTimesDiv(passedList: MutableList<Any>): MutableList<Any> {
        val newList = mutableListOf<Any>()
        var restartIndex = passedList.size

        for (i in passedList.indices) {
            if (passedList[i] is Char && i !=passedList.lastIndex && i < restartIndex) {
                val operator = passedList[i]
                val prevDigit = passedList[i - 1] as Float
                val nextDigit = passedList[i + 1] as Float
                when (operator) {
                    'x' -> {
                        newList.add(prevDigit * nextDigit)
                        restartIndex = i + 1
                    }
                    '÷' -> {
                        newList.add(prevDigit / nextDigit)
                        restartIndex = i + 1
                    }
                    else -> {
                        newList.add(prevDigit)
                        newList.add(operator)
                    }
                }
            }
            if (i > restartIndex)
                newList.add(passedList[i])
        }

        return newList
    }

    private fun digitsOpr(): MutableList<Any> {
        val list = mutableListOf<Any>()
        var currentDigit = ""
        for (character in tv_opr.text) {
            if (character.isDigit() || character == '.')
                currentDigit += character
            else {
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(character)
            }
        }

        if (currentDigit != "")
            list.add(currentDigit.toFloat())

        return list
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