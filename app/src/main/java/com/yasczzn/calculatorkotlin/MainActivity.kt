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
            findNavController(R.id.calc_frame).navigate(R.id.action_calculatorFragment_to_convertorFragment)
        })

        mViewPager!!.addOnPageChangeListener(ViewPager . OnPageChangeListener () {
            fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        supportActionBar?.setTitle(R.string.calc_page)
                    }
                    1 -> {
                        supportActionBar?.setTitle(R.string.conv_page)
                    }
                    else -> {}
                }
            }
    }
}