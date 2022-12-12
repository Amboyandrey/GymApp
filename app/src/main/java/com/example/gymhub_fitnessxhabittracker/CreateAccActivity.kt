package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.gymhub_fitnessxhabittracker.databinding.ActivityCreateAccBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_create_acc.*
import kotlinx.android.synthetic.main.activity_login.visibility

class CreateAccActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCreateAccBinding
    private lateinit var database : DatabaseReference

    private var mIsShowPass = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccBinding.inflate(layoutInflater)
        setContentView(binding.root)

        visibility.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }

        visibility2.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword1(mIsShowPass)
        }

        showPassword(mIsShowPass)

        val pass1 = findViewById<EditText>(R.id.createTextPassword1)
        val pass2 = findViewById<EditText>(R.id.createTextPassword2)
        val username = findViewById<EditText>(R.id.createTextPersonName1)
        val emailid = findViewById<EditText>(R.id.createTextEmailAddress)

        binding.signupBtn.setOnClickListener(View.OnClickListener {
            if (username.length() == 0){
                Toast.makeText(this,"Please input your Username", Toast.LENGTH_LONG).show()
            }else if (username.length() < 6){
                Toast.makeText(this,"Minimum 8 Character Username", Toast.LENGTH_LONG).show()
            }else if (username.text.trim().toString().matches(".*[.#$].*".toRegex())){
                Toast.makeText(this,"Special characters like .#$ not allowed", Toast.LENGTH_LONG).show()
            }else if (pass1.length() == 0){
                Toast.makeText(this,"Please input your Password", Toast.LENGTH_LONG).show()
            }else if (pass1.length() < 6){
                Toast.makeText(this,"Minimum 8 Character Password", Toast.LENGTH_LONG).show()
            }else if (pass1.text.trim().toString() != pass2.text.trim().toString()){
                Toast.makeText(this,"Password not match", Toast.LENGTH_LONG).show()
            }else if (!pass1.text.trim().toString().matches(".*[A-Z].*".toRegex())){
                Toast.makeText(this,"Password Must Contain 1 Upper-case Character", Toast.LENGTH_LONG).show()
            }else if (!pass1.text.trim().toString().matches(".*[a-z].*".toRegex())){
                Toast.makeText(this,"Password Must Contain 1 Lower-case Character", Toast.LENGTH_LONG).show()
            }else if (!pass1.text.trim().toString().matches(".*[0-9].*".toRegex())){
                Toast.makeText(this,"Password Must Contain 1 Digit", Toast.LENGTH_LONG).show()
            }else if (emailid.length() == 0) {
                Toast.makeText(this, "Please input your Email", Toast.LENGTH_LONG).show()
            }else if (!Patterns.EMAIL_ADDRESS.matcher(emailid.text.trim().toString()).matches()) {
                Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_LONG).show()
            }else{
                val uname = binding.createTextPersonName1.text.trim().toString()
                val pass = binding.createTextPassword1.text.trim().toString()
                val email = binding.createTextEmailAddress.text.trim().toString()

                database = FirebaseDatabase.getInstance().getReference("Users")
                val user = User(uname, pass, email)
                globalDataHolder.uname = uname
                globalDataHolder.pass = pass
                globalDataHolder.email = email

                database.child(uname).setValue(user).addOnSuccessListener {
                    createTextPersonName1.text.clear()
                    createTextPassword1.text.clear()
                    createTextEmailAddress.text.clear()
                    createTextPassword2.text.clear()
                }

                val intent = Intent(this,WelcometermsActivity::class.java)
                startActivity(intent)
            }
        })
    }

    private fun showPassword(isShow: Boolean){
        if (isShow) {
            createTextPassword1.transformationMethod = HideReturnsTransformationMethod.getInstance()
            visibility.setImageResource(R.drawable.ic_baseline_visibility_off)
        }else{
            createTextPassword1.transformationMethod = PasswordTransformationMethod.getInstance()
            visibility.setImageResource(R.drawable.ic_baseline_remove_red_eye)
        }
        createTextPassword1.setSelection(createTextPassword1.text.toString().length)
    }
    private fun showPassword1(isShow: Boolean){
        if (isShow) {
            createTextPassword2.transformationMethod = HideReturnsTransformationMethod.getInstance()
            visibility2.setImageResource(R.drawable.ic_baseline_visibility_off)
        }else{
            createTextPassword2.transformationMethod = PasswordTransformationMethod.getInstance()
            visibility2.setImageResource(R.drawable.ic_baseline_remove_red_eye)
        }
        createTextPassword2.setSelection(createTextPassword2.text.toString().length)
    }
}