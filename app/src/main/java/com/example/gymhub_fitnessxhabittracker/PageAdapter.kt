package com.example.gymhub_fitnessxhabittracker

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {RegularFragment() }
            1 -> {NegativeFragment() }
            2 -> {OneTimeFragment() }
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }
}