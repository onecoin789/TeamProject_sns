package com.example.teamproject_sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text


class DetailActivity : AppCompatActivity() {
    private var email:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val emailMy = findViewById<TextView>(R.id.emailTextView)



        val bundle: Bundle? = intent.extras
        val emailGet = bundle?.getString("email")

        //  name = intent.getStringExtra("name")
        email = intent.getStringExtra("email")

        //TextView에 데이터 설정
        emailMy.text = email



        emailMy.text = emailGet

        val btn_close = findViewById<ImageView>(R.id.img_Detail_Close);
        btn_close.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)



        }
    }
}