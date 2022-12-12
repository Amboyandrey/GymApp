package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_workoutday2.*
import java.text.SimpleDateFormat
import java.util.*

class workoutday2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workoutday2)

        accountBtn.setOnClickListener {
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }

        val calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("MMM dd")
        val currentDate = simpleDateFormat.format(calendar.time)
        datetxt.text = currentDate

        btn1.setOnClickListener {
            val intent = Intent(this, warmuup::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this, reps::class.java)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            val intent = Intent(this, cooldown::class.java)
            startActivity(intent)
        }
    }
}