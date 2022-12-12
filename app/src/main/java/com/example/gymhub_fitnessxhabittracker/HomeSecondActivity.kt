package com.example.gymhub_fitnessxhabittracker

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeSecondActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_second)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = PageAdapter(this)
        TabLayoutMediator(tabLayout,viewPager){ tab, index ->
            tab.text = when(index){
                0 -> {"REGULAR"}
                1 -> {"NEGATIVE"}
                2 -> {"SCHEDULED"}
                else -> {throw Resources.NotFoundException("Position Not Found")}
            }
        }.attach()

    }
}