package com.example.gymhub_fitnessxhabittracker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.gymhub_fitnessxhabittracker.databinding.ActivityHomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class HomeActivity : AppCompatActivity() {

    var backPressedTime: Long = 0
    private lateinit var binding : ActivityHomeBinding
    private lateinit var database : DatabaseReference

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HabitFragment())

        val uname = globalDataHolder.uname

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uname).get().addOnSuccessListener {

            val fname = it.child("fname").value

            binding.textView6.text = fname.toString()
        }

        val accButton = findViewById<Button>(R.id.accountBtn)
        accButton.setOnClickListener {
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.bottomNav.setOnItemSelectedListener {

            when(it.itemId){
                R.id.habit -> replaceFragment(HabitFragment())
                R.id.workout -> replaceFragment(WorkoutFragment())
                R.id.history -> replaceFragment(DataFragment())
                R.id.meal -> replaceFragment(MealFragment())

                else ->{
                }
            }
            true
        }

        val calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("MMM dd")
        val currentDate = simpleDateFormat.format(calendar.time)
        val textViewDate: TextView = findViewById(R.id.datetxt)
        textViewDate.text = currentDate

    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
            finishAffinity()
            finish()
        }else{
            Toast.makeText(this, "Press back again to exit the app.", Toast.LENGTH_LONG).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}