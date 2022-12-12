package com.example.gymhub_fitnessxhabittracker

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.gymhub_fitnessxhabittracker.databinding.FragmentDataBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DataFragment : Fragment() {

    private lateinit var tabLayout2: TabLayout
    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentDataBinding.inflate(layoutInflater)

        tabLayout2 = bind.tabLayout2
        viewPager2 = bind.viewPager2

        viewPager2.adapter = DataAdapter(this)
        TabLayoutMediator(tabLayout2,viewPager2){ tab, index ->
            tab.text = when(index){
                0 -> {"HABIT HISTORY"}
                1 -> {"ALL HABITS"}
                2 -> {"FITNESS PROGRESS"}
                else -> {throw Resources.NotFoundException("Position Not Found")}
            }
        }.attach()

        return bind.root
    }

}