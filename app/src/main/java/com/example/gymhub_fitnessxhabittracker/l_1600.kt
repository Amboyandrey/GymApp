package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_l1600.*
import java.text.SimpleDateFormat
import java.util.*

class l_1600 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l1600)

        accountBtn.setOnClickListener {
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }

        val calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("MMM dd")
        val currentDate = simpleDateFormat.format(calendar.time)
        datetxt.text = currentDate
    }
}