package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymhub_fitnessxhabittracker.databinding.FragmentWorkoutBinding

class WorkoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentWorkoutBinding.inflate(layoutInflater)

        bind.btn1.setOnClickListener {
            val intent = Intent(this@WorkoutFragment.requireContext(), workoutday1::class.java)
            startActivity(intent)
        }
        bind.btn2.setOnClickListener {
            val intent = Intent(this@WorkoutFragment.requireContext(), workoutday2::class.java)
            startActivity(intent)
        }
        bind.btn3.setOnClickListener {
            val intent = Intent(this@WorkoutFragment.requireContext(), workoutday3::class.java)
            startActivity(intent)
        }
        bind.btn4.setOnClickListener {
            val intent = Intent(this@WorkoutFragment.requireContext(), workoutday4::class.java)
            startActivity(intent)
        }

        return bind.root
    }

}