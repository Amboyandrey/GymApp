package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymhub_fitnessxhabittracker.databinding.FragmentRegularBinding

class RegularFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentRegularBinding.inflate(layoutInflater)

        bind.regBtn.setOnClickListener {
            val intent = Intent(this@RegularFragment.requireContext(), CreateReg::class.java)
            startActivity(intent)
        }

        return bind.root
    }

}