package com.example.calculatorkotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.calculatorkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private val mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnChange.setOnClickListener(View.OnClickListener {
            if(view!=CalculatorFragment) {
                findNavController(R.id.calc_frame).navigate(R.id.action_convertorFragment_to_calculatorFragment)
            } else {
                findNavController(R.id.calc_frame).navigate(R.id.action_calculatorFragment_to_convertorFragment)
            }
        })
    }
}