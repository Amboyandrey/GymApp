package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymhub_fitnessxhabittracker.databinding.FragmentNegativeBinding

class NegativeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentNegativeBinding.inflate(layoutInflater)

        bind.negBtn.setOnClickListener {
            val intent = Intent(this@NegativeFragment.requireContext(), CreateNeg::class.java)
            startActivity(intent)
        }

        return bind.root
    }

}