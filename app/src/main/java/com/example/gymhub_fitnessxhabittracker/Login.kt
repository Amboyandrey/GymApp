package com.example.gymhub_fitnessxhabittracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    private lateinit var database : DatabaseReference
    private var backPressedTime: Long = 0

    private var mIsShowPass = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        visibility.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }

        showPassword(mIsShowPass)

        val loginButton = findViewById<Button>(R.id.loginBtn)
        loginButton.setOnClickListener {

            if (editTextTextPersonName.text.trim().toString().matches(".*[.#$].*".toRegex())){
                Toast.makeText(this,"Login Failed", Toast.LENGTH_LONG).show()
            } else {
                val textId = findViewById<EditText>(R.id.editTextTextPersonName)
                val textPassword = findViewById<EditText>(R.id.editTextTextPassword)

                val uname = textId.text.toString()
                globalDataHolder.uname = uname

                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(uname).get().addOnSuccessListener {

                    if (textId.text.trim().toString() == it.child("uname").value &&
                        textPassword.text.trim().toString() == it.child("pass").value
                    ) {
                        Toast.makeText(this, "Login Complete", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        val createAccButton = findViewById<Button>(R.id.createBtn)
        createAccButton.setOnClickListener {
            val intent = Intent(this,CreateAccActivity::class.java)
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

    private fun showPassword(isShow: Boolean){
        if (isShow) {
            editTextTextPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            visibility.setImageResource(R.drawable.ic_baseline_visibility_off)
        }else{
            editTextTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            visibility.setImageResource(R.drawable.ic_baseline_remove_red_eye)
        }
        editTextTextPassword.setSelection(editTextTextPassword.text.toString().length)
    }
}