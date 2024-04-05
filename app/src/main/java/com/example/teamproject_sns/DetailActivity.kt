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

        val imageMy = findViewById<ImageView>(R.id.img_Detail_Title)
        val emailMy = findViewById<TextView>(R.id.text_Detail_Mail)
        val emailMy2 = findViewById<TextView>(R.id.text_Detail_Mail2)
        val tilMy = findViewById<TextView>(R.id.text_Detail_Text)

        val bundle: Bundle? = intent.extras
        val imageGet = bundle!!.getInt("image")
        val tilGet = bundle?.getString("til")
        val emailGet = bundle?.getString("email")

        //  name = intent.getStringExtra("name")
        email = intent.getStringExtra("email")

        //TextView에 데이터 설정
        emailMy.text = email
        emailMy2.text = email


        imageMy.setImageResource(imageGet)
        emailMy.text = emailGet
        emailMy2.text = emailGet
        tilMy.text = tilGet

        val btn_close = findViewById<ImageView>(R.id.img_Detail_Close);
        btn_close.setOnClickListener {
            finish()



        }
    }
}