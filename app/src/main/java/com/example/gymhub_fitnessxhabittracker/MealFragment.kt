package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymhub_fitnessxhabittracker.databinding.FragmentMealBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MealFragment : Fragment() {

    private lateinit var database : DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentMealBinding.inflate(layoutInflater)

        val uname = globalDataHolder.uname

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uname).get().addOnSuccessListener {

            val calo = it.child("cal").value

            val cal = calo.toString()

            bind.calories.text = cal

            bind.bp.setOnClickListener {
                if (cal >= 1600.toString() && cal <= 1799.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), bp_1600::class.java)
                    startActivity(intent)
                } else if (cal >= 1800.toString() && cal <= 1999.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), bp_1800::class.java)
                    startActivity(intent)
                } else if (cal >= 2000.toString() && cal <= 2199.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), bp_2000::class.java)
                    startActivity(intent)
                } else if (cal >= 2200.toString() && cal <= 2399.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), bp_2200::class.java)
                    startActivity(intent)
                } else if (cal >= 2400.toString() && cal <= 2599.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), bp_2400::class.java)
                    startActivity(intent)
                } else if (cal >= 2600.toString() && cal <= 2799.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), bp_2600::class.java)
                    startActivity(intent)
                } else if (cal >= 2800.toString() && cal <= 2999.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), bp_2800::class.java)
                    startActivity(intent)
                } else if (cal >= 3000.toString() && cal <= 3199.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), bp_3000::class.java)
                    startActivity(intent)
                } else {
                    val intent =
                        Intent(this@MealFragment.requireContext(), MealFragment::class.java)
                    startActivity(intent)
                }
            }

            bind.s.setOnClickListener {
                if (cal >= 1600.toString() && cal <= 1799.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), s_1600::class.java)
                    startActivity(intent)
                } else if (cal >= 1800.toString() && cal <= 1999.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), s_1800::class.java)
                    startActivity(intent)
                } else if (cal >= 2000.toString() && cal <= 2199.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), s_2000::class.java)
                    startActivity(intent)
                } else if (cal >= 2200.toString() && cal <= 2399.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), s_2200::class.java)
                    startActivity(intent)
                } else if (cal >= 2400.toString() && cal <= 2599.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), s_2400::class.java)
                    startActivity(intent)
                } else if (cal >= 2600.toString() && cal <= 2799.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), s_2600::class.java)
                    startActivity(intent)
                } else if (cal >= 2800.toString() && cal <= 2999.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), s_2800::class.java)
                    startActivity(intent)
                } else if (cal >= 3000.toString() && cal <= 3199.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), s_3000::class.java)
                    startActivity(intent)
                } else {
                    val intent =
                        Intent(this@MealFragment.requireContext(), MealFragment::class.java)
                    startActivity(intent)
                }
            }

            bind.L.setOnClickListener {
                if (cal >= 1600.toString() && cal <= 1799.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), l_1600::class.java)
                    startActivity(intent)
                } else if (cal >= 1800.toString() && cal <= 1999.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), l_1800::class.java)
                    startActivity(intent)
                } else if (cal >= 2000.toString() && cal <= 2199.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), l_2000::class.java)
                    startActivity(intent)
                } else if (cal >= 2200.toString() && cal <= 2399.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), l_2200::class.java)
                    startActivity(intent)
                } else if (cal >= 2400.toString() && cal <= 2599.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), l_2400::class.java)
                    startActivity(intent)
                } else if (cal >= 2600.toString() && cal <= 2799.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), l_2600::class.java)
                    startActivity(intent)
                } else if (cal >= 2800.toString() && cal <= 2999.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), l_2800::class.java)
                    startActivity(intent)
                } else if (cal >= 3000.toString() && cal <= 3199.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), l_3000::class.java)
                    startActivity(intent)
                } else {
                    val intent =
                        Intent(this@MealFragment.requireContext(), MealFragment::class.java)
                    startActivity(intent)
                }
            }

            bind.m.setOnClickListener {
                if (cal >= 1600.toString() && cal <= 1799.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), m_1600::class.java)
                    startActivity(intent)
                } else if (cal >= 1800.toString() && cal <= 1999.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), m_1800::class.java)
                    startActivity(intent)
                } else if (cal >= 2000.toString() && cal <= 2199.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), m_2000::class.java)
                    startActivity(intent)
                } else if (cal >= 2200.toString() && cal <= 2399.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), m_2200::class.java)
                    startActivity(intent)
                } else if (cal >= 2400.toString() && cal <= 2599.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), m_2400::class.java)
                    startActivity(intent)
                } else if (cal >= 2600.toString() && cal <= 2799.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), m_2600::class.java)
                    startActivity(intent)
                } else if (cal >= 2800.toString() && cal <= 2999.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), m_2800::class.java)
                    startActivity(intent)
                } else if (cal >= 3000.toString() && cal <= 3199.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), m_3000::class.java)
                    startActivity(intent)
                } else {
                    val intent =
                        Intent(this@MealFragment.requireContext(), MealFragment::class.java)
                    startActivity(intent)
                }
            }

            bind.d.setOnClickListener {
                if (cal >= 1600.toString() && cal <= 1799.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), d_1600::class.java)
                    startActivity(intent)
                } else if (cal >= 1800.toString() && cal <= 1999.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), d_1800::class.java)
                    startActivity(intent)
                } else if (cal >= 2000.toString() && cal <= 2199.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), d_2000::class.java)
                    startActivity(intent)
                } else if (cal >= 2200.toString() && cal <= 2399.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), d_2200::class.java)
                    startActivity(intent)
                } else if (cal >= 2400.toString() && cal <= 2599.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), d_2400::class.java)
                    startActivity(intent)
                } else if (cal >= 2600.toString() && cal <= 2799.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), d_2600::class.java)
                    startActivity(intent)
                } else if (cal >= 2800.toString() && cal <= 2999.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), d_2800::class.java)
                    startActivity(intent)
                } else if (cal >= 3000.toString() && cal <= 3199.toString()) {
                    val intent = Intent(this@MealFragment.requireContext(), d_3000::class.java)
                    startActivity(intent)
                } else {
                    val intent =
                        Intent(this@MealFragment.requireContext(), MealFragment::class.java)
                    startActivity(intent)
                }
            }

        }
        return bind.root
    }

}