package com.example.teamproject_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher

class StartActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val tvLogin = findViewById<TextView>(R.id.tv_login)

        val btnJoin = findViewById<Button>(R.id.btn_signUp)

       btnJoin.setOnClickListener {
           val intent = Intent(this, JoinActivity::class.java)

           startActivity(intent)
       }

        tvLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}