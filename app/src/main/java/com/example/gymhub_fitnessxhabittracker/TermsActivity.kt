package com.example.gymhub_fitnessxhabittracker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class TermsActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)

        val chk = findViewById<CheckBox>(R.id.checkBox)
        val btn = findViewById<Button>(R.id.continueBtn)
        btn.setOnClickListener(View.OnClickListener {
            if (chk.isChecked){
                val intent = Intent(this,UserActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Please accept the terms and conditions.", Toast.LENGTH_LONG).show()
            }
        })
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