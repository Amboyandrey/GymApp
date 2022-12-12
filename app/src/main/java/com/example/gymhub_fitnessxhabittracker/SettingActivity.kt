package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val activeButton = findViewById<Button>(R.id.signoutBtn)
        activeButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        val habitlistButton = findViewById<TextView>(R.id.textView20)
        habitlistButton.setOnClickListener {
            val intent = Intent(this, HabitList::class.java)
            startActivity(intent)
        }
        val workutlistButton = findViewById<TextView>(R.id.textView35)
        workutlistButton.setOnClickListener {
            val intent = Intent(this, WorkoutList::class.java)
            startActivity(intent)
        }
        val editprofileButton = findViewById<TextView>(R.id.textView36)
        editprofileButton.setOnClickListener {
            val intent = Intent(this, editprofile::class.java)
            startActivity(intent)
        }
    }
}