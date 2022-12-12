package com.example.gymhub_fitnessxhabittracker

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymhub_fitnessxhabittracker.databinding.ActivityCreateRegBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_create_reg.*
import java.util.*

class CreateReg : AppCompatActivity() {

    private lateinit var binding : ActivityCreateRegBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chip6.setOnClickListener {
            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val day = myCalendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this,{ view, year, month, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "/" + (month + 1) + "/" + year)
                chip6.setText(dat)
            },
                year, month, day
            )
            datePicker.show()
        }

        binding.saveHabit.setOnClickListener {

            val habitname = binding.editText.text.trim().toString()
            val endon = binding.chip6.text.trim().toString()

            val uname = globalDataHolder.uname

            database = FirebaseDatabase.getInstance().getReference("Users")
            val habit = Habit(habitname, endon)

            globalDataHolder.regHabitname = habitname
            database.child(uname).child("Regular").child(habitname).setValue(habit).addOnSuccessListener {
                editText.text.clear()
            }

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}