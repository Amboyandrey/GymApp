package com.example.gymhub_fitnessxhabittracker

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DataAdapter(fragmentActivity: DataFragment) : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {HistoryFragment() }
            1 -> {AllListFragment() }
            2 -> {ProgressFragment() }
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }
}