@file:Suppress("UNUSED_VARIABLE", "DEPRECATION")

package com.example.gymhub_fitnessxhabittracker

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val connectionManager: ConnectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectionManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        Toast.makeText(this, "By TEAM 4", Toast.LENGTH_SHORT).show()

        if (isConnected) {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            }, 3000)

        }else{
            Toast.makeText(this,"You are not connected to the Internet", Toast.LENGTH_LONG).show()
            finishAffinity()
            finish()
        }
    }
}