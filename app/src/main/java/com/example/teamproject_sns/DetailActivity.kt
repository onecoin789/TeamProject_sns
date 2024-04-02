package com.example.teamproject_sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btn_close = findViewById<ImageView>(R.id.img_Detail_Close);
        btn_close.setOnClickListener {
            finish()
        }


    }
}