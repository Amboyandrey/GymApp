package com.example.gymhub_fitnessxhabittracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymhub_fitnessxhabittracker.databinding.FragmentAllListBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AllListFragment : Fragment() {

    private lateinit var database : DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentAllListBinding.inflate(layoutInflater)

        val uname = globalDataHolder.uname
        val reghabit = globalDataHolder.regHabitname
        val neghabit = globalDataHolder.negHabitName
        val schedhabit = globalDataHolder.schedHabitName

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uname).child("Regular").child(reghabit).get().addOnSuccessListener {

            val habitreg = it.child("habitname").value

            bind.chip6.text = habitreg.toString()

        }
        database.child(uname).child("Negative").child(neghabit).get().addOnSuccessListener {

            val habitneg = it.child("habitname").value

            bind.chip7.text = habitneg.toString()

        }
        database.child(uname).child("Scheduled").child(schedhabit).get().addOnSuccessListener {

            val habitneg = it.child("habitname").value

            bind.chip8.text = habitneg.toString()

        }

        return bind.root
    }

}