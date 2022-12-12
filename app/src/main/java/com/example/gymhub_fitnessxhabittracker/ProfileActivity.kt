package com.example.gymhub_fitnessxhabittracker

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.gymhub_fitnessxhabittracker.databinding.ActivityProfileBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val settingButton = findViewById<Button>(R.id.settingtBtn)
        settingButton.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

        val uname = globalDataHolder.uname

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uname).get().addOnSuccessListener {

            val fname = it.child("fname").value
            val lname = it.child("lname").value
            val wt = it.child("wt").value
            val ht = it.child("ht").value
            val bday = it.child("bday").value
            val bmi = it.child("bmi").value
            val gender = it.child("gender").value

            binding.textView9.text = gender.toString()
            binding.textView6.text = fname.toString()
            binding.textView7.text = lname.toString()
            binding.textView8.text = bday.toString()
            binding.textView10.text = wt.toString()
            binding.textView11.text = ht.toString()
            binding.textView12.text = bmi.toString()

        }
        textView12.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.bmi,null)
            val bmi = Dialog(this)
            bmi.setContentView(dialogBinding)

            bmi.setCancelable(true)
            bmi.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            bmi.show()
        }
        val editprofileButton = findViewById<ImageButton>(R.id.pen)
        editprofileButton.setOnClickListener {
            val intent = Intent(this, editprofile::class.java)
            startActivity(intent)
        }

    }
}