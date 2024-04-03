package com.example.teamproject_sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class DetailActivity : AppCompatActivity() {
    lateinit var data: MyPageData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initData()

        val btn_close = findViewById<ImageView>(R.id.img_Detail_Close);
        btn_close.setOnClickListener {
            finish()
        }
    }
    private fun initData() {
        if(intent.hasExtra("mail") && intent.hasExtra("text")) {
            var mail = findViewById<TextView>(R.id.text_Detail_mail)
            var text = findViewById<TextView>(R.id.text_Detail_Text)

        }
    }
}