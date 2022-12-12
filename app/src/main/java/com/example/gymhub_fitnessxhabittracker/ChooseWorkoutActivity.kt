package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChooseWorkoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_workout)

        val nextButton = findViewById<Button>(R.id.nextBtn)
        nextButton.setOnClickListener {
            val intent = Intent(this, ListWorkoutActivity::class.java)
            startActivity(intent)
        }
    }
}