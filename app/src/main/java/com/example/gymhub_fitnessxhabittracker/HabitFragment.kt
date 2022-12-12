package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymhub_fitnessxhabittracker.databinding.FragmentHabitBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.childEvents

class HabitFragment : Fragment() {

    private lateinit var database : DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentHabitBinding.inflate(layoutInflater)

        bind.secondActivityBtn.setOnClickListener {
            val intent = Intent(this@HabitFragment.requireContext(), HomeSecondActivity::class.java)
            startActivity(intent)
        }

        val uname = globalDataHolder.uname
        val reghabit = globalDataHolder.regHabitname
        val neghabit = globalDataHolder.negHabitName

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uname).child("Regular").child(reghabit).get().addOnSuccessListener {

            val habitreg = it.child("habitname").value

            bind.chip6.text = habitreg.toString()

        }
        database.child(uname).child("Negative").child(neghabit).get().addOnSuccessListener {

            val habitneg = it.child("habitname").value

            bind.chip7.text = habitneg.toString()

        }

        return bind.root
    }


    /*val secondActButton = findViewById<Button>(R.id.secondActivityBtn)
    secondActButton.setOnClickListener {
        val intent = Intent(this,HomeSecondActivity::class.java)
        startActivity(intent)
    }*/
}