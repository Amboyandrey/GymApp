package com.example.gymhub_fitnessxhabittracker

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.gymhub_fitnessxhabittracker.databinding.ActivityEditprofileBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_editprofile.*
import java.text.DecimalFormat
import java.util.*

class editprofile : AppCompatActivity() {

    private lateinit var binding : ActivityEditprofileBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditprofileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uname = globalDataHolder.uname

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uname).get().addOnSuccessListener {

            val age = it.child("age").value
            val fname = it.child("fname").value
            val lname = it.child("lname").value
            val wt = it.child("wt").value
            val ht = it.child("ht").value
            val bday = it.child("bday").value

            val age1 = age.toString()
            val fname1 = fname.toString()
            val lname1 = lname.toString()
            val bday1 = bday.toString()
            val wt1 = wt.toString()
            val ht1 = ht.toString()

            binding.editTextAge.setText(age1)
            binding.firstName.setText(fname1)
            binding.editTextTextPersonName2.setText(lname1)
            binding.editTextDate.setText(bday1)
            binding.editTextWeight.setText(wt1)
            binding.editTextHeight.setText(ht1)

        }

        val name = findViewById<EditText>(R.id.editTextTextPersonName2)
        val name2 = findViewById<EditText>(R.id.firstName)
        val date = findViewById<EditText>(R.id.editTextDate)
        val rdio = findViewById<RadioButton>(R.id.radioButton)
        val rdio2 = findViewById<RadioButton>(R.id.radioButton2)
        val wght = findViewById<EditText>(R.id.editTextWeight)
        val hght = findViewById<EditText>(R.id.editTextHeight)

        binding.saveBtn.setOnClickListener(View.OnClickListener {

            if (name2.length() == 0){
                Toast.makeText(this,"Please input your First Name", Toast.LENGTH_LONG).show()
            }else if (name.length() == 0){
                Toast.makeText(this,"Please input your Last Name", Toast.LENGTH_LONG).show()
            }else if (editTextAge.length() == 0){
                Toast.makeText(this,"Please input your Age", Toast.LENGTH_LONG).show()
            }else if (date.length() == 0){
                Toast.makeText(this,"Please input your Birthdate", Toast.LENGTH_LONG).show()
            }else if (!rdio.isChecked && !rdio2.isChecked){
                Toast.makeText(this,"Please select your Gender", Toast.LENGTH_LONG).show()
            }else if (wght.length() == 0){
                Toast.makeText(this,"Please input your Weight", Toast.LENGTH_LONG).show()
            }else if (hght.length() == 0){
                Toast.makeText(this,"Please input your Height", Toast.LENGTH_LONG).show()
            }else{
                val height = binding.editTextHeight.text.trim().toString()
                val doubleHeight = height.toDouble() / 100
                val weight = binding.editTextWeight.text.trim().toString()
                val bmicompute = weight.toDouble() / (doubleHeight * doubleHeight)
                val format = DecimalFormat("0.00")

                val bmi = format.format(bmicompute).toString()
                val fname = binding.firstName.text.trim().toString()
                val lname = binding.editTextTextPersonName2.text.trim().toString()
                val age = binding.editTextAge.text.trim().toString()
                val bday = binding.editTextDate.text.trim().toString()
                val wt = binding.editTextWeight.text.trim().toString()
                val ht = binding.editTextHeight.text.trim().toString()

                val uname = globalDataHolder.uname
                val pass = globalDataHolder.pass
                val email = globalDataHolder.email

                database = FirebaseDatabase.getInstance().getReference("Users")
                val user = User(uname, pass, email, fname, lname, bday, age, gender = "", wt, ht, bmi, cal = "")

                globalDataHolder.uname = uname
                globalDataHolder.pass = pass
                globalDataHolder.email = email
                globalDataHolder.fname = fname
                globalDataHolder.lname = lname
                globalDataHolder.bday = bday
                globalDataHolder.age = age
                globalDataHolder.wt = wt
                globalDataHolder.ht = ht
                globalDataHolder.bmi = bmi

                database.child(uname).setValue(user).addOnSuccessListener {
                    firstName.text.clear()
                    editTextTextPersonName2.text.clear()
                    editTextDate.text.clear()
                    editTextWeight.text.clear()
                    editTextHeight.text.clear()
                }
                if (rdio.isChecked){
                    val b = weight.toDouble() * 13.75
                    val c = height.toDouble() * 5.003
                    val d = age.toDouble() * 6.75
                    val bmr = 66.5 + b + c - d
                    val light = bmr * 1.375

                    val cal = format.format(light).toString()
                    val gender = binding.radioButton.text.toString()
                    database = FirebaseDatabase.getInstance().getReference("Users")
                    val user = User(uname, pass, email, fname, lname, bday, age, gender, wt, ht, bmi, cal)

                    globalDataHolder.cal = cal
                    globalDataHolder.gender = gender
                    database.child(uname).setValue(user).addOnSuccessListener {
                    }
                }else{
                    val b = weight.toDouble() * 19.563
                    val c = height.toDouble() * 1.850
                    val d = age.toDouble() * 4.676
                    val bmr = 66.5 + b + c - d
                    val light = bmr * 1.375

                    val cal = light.toString()
                    val gender = binding.radioButton2.text.toString()
                    database = FirebaseDatabase.getInstance().getReference("Users")
                    val user = User(uname, pass, email, fname, lname, bday, age, gender, wt, ht, bmi, cal)

                    globalDataHolder.cal = cal
                    globalDataHolder.gender = gender
                    database.child(uname).setValue(user).addOnSuccessListener {
                    }
                }
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }
        })
        date.setOnClickListener {
            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val day = myCalendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this,{ view, year, month, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "/" + (month + 1) + "/" + year)
                date.setText(dat)
            },
                year, month, day
            )
            datePicker.show()
        }

    }
}