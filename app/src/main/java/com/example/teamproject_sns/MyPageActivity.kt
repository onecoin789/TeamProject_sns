package com.example.teamproject_sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val close = findViewById<ImageView>(R.id.img_Close_Btn)

        close.setOnClickListener{
            finish()
        }
    }
}