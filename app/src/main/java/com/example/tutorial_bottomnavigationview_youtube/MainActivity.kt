package com.example.tutorial_bottomnavigationview_youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.tutorial_bottomnavigationview_youtube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setCurrentFragment(firstFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
           when(it.itemId) {
               R.id.miHome -> setCurrentFragment(firstFragment)
               R.id.miMessages -> setCurrentFragment(secondFragment)
               R.id.miProfile -> setCurrentFragment(thirdFragment)
           }
            true
        }

        binding.bottomNavigationView.getOrCreateBadge(R.id.miMessages).apply{
            number = 10
            isVisible = true
        }

    }

    private fun setCurrentFragment(fragment : Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}