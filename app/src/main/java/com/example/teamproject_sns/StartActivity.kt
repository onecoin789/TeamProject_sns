package com.example.teamproject_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val tvLogin = findViewById<TextView>(R.id.tv_login)

//        btnLogin.setOnClickListener {
//            intent = Intent(this, SignUpActivity::class.java)
//            StartActivity(intent)
//        }

        tvLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}