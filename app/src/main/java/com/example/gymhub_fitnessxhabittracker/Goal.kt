package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Goal : AppCompatActivity() {

    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal)

        val gainButton = findViewById<Button>(R.id.imageBtn)
        gainButton.setOnClickListener {
            val intent = Intent(this, ActiveActivity::class.java)
            startActivity(intent)
        }
        val loseButton = findViewById<Button>(R.id.imageBtn2)
        loseButton.setOnClickListener {
            val intent = Intent(this, ActiveActivity::class.java)
            startActivity(intent)
        }
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