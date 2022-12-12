package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val pickButton = findViewById<Button>(R.id.imageBtnPick)
        pickButton.setOnClickListener {
            val intent = Intent(this, PickSugested::class.java)
            startActivity(intent)
        }

        val customButton = findViewById<Button>(R.id.imageBtnCustom)
        customButton.setOnClickListener {
            val intent = Intent(this, ChooseWorkoutActivity::class.java)
            startActivity(intent)
        }
    }
}