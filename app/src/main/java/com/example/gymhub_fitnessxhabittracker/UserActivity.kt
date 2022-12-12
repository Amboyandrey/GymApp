package com.example.gymhub_fitnessxhabittracker

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.gymhub_fitnessxhabittracker.databinding.ActivityUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_user.*
import java.text.DecimalFormat
import java.util.*

class UserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUserBinding
    private lateinit var database : DatabaseReference
    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*var args = listOf<String>(firstName.text.toString(), editTextTextPersonName2.text.toString(), editTextDate.text.toString(), editTextWeight.text.toString(), editTextHeight.text.toString()).toTypedArray()
        var rs = db.rawQuery("SELECT * FROM USERS WHERE UNAME = ? AND PASS = ?",args)

        if (rs.moveToNext())
            Toast.makeText(applicationContext, "Input Approved", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(applicationContext, "Invalid Credential", Toast.LENGTH_LONG).show()*/

        val name = findViewById<EditText>(R.id.editTextTextPersonName2)
        val name2 = findViewById<EditText>(R.id.firstName)
        val date = findViewById<EditText>(R.id.editTextDate)
        val rdio = findViewById<RadioButton>(R.id.radioButton)
        val rdio2 = findViewById<RadioButton>(R.id.radioButton2)
        val wght = findViewById<EditText>(R.id.editTextWeight)
        val hght = findViewById<EditText>(R.id.editTextHeight)

        binding.nextBtn.setOnClickListener(View.OnClickListener {

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
                val intent = Intent(this,Goal::class.java)
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

    /*private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        date1.setText(sdf.format(myCalendar.time))
    }*/
}