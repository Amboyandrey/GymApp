package com.example.gymhub_fitnessxhabittracker

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymhub_fitnessxhabittracker.databinding.ActivityCreateSchedBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_create_sched.*
import java.util.*

class CreateSched : AppCompatActivity() {

    private lateinit var binding : ActivityCreateSchedBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateSchedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        schedBtn.setOnClickListener {
            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val day = myCalendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this,{ view, year, month, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "/" + (month + 1) + "/" + year)
                Date.setText(dat)
            },
                year, month, day
            )
            datePicker.show()
        }

        binding.saveHabit.setOnClickListener {

            val habitname = binding.editText.text.trim().toString()
            val seton = binding.Date.text.trim().toString()

            val uname = globalDataHolder.uname

            database = FirebaseDatabase.getInstance().getReference("Users")
            val habit = Habit(habitname, seton)

            globalDataHolder.schedHabitName = habitname
            database.child(uname).child("Scheduled").child(habitname).setValue(habit).addOnSuccessListener {
                editText.text.clear()
            }

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}