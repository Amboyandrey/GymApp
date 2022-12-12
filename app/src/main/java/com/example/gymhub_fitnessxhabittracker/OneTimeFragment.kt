package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymhub_fitnessxhabittracker.databinding.FragmentOneTimeBinding

class OneTimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentOneTimeBinding.inflate(layoutInflater)

        bind.otBtn.setOnClickListener {
            val intent = Intent(this@OneTimeFragment.requireContext(), CreateSched::class.java)
            startActivity(intent)
        }

        return bind.root
    }

}