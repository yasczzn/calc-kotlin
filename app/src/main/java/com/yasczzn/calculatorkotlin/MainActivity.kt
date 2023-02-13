package com.yasczzn.calculatorkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.yasczzn.calculatorkotlin.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager: ViewPager2 = binding.vpager
        val tabs: TabLayout = binding.tablayout

        viewPager.adapter = TabAdapter(this)

        TabLayoutMediator(tabs, viewPager) {tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Calculator"
                }
                1 -> {
                    tab.text = "Convertor"
                }
            }}.attach()

    }

    class TabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> CalculatorFragment.newInstance()
                1 -> ConvertorFragment.newInstance()
                else -> CalculatorFragment.newInstance()
            }
        }
    }

}