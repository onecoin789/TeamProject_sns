package com.example.teamproject_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etId = findViewById<EditText>(R.id.et_email)
        val etPw = findViewById<EditText>(R.id.et_pw)
        val id = etId.text.toString()
        val pw = etPw.text.toString()
        val btnLogin = findViewById<Button>(R.id.btn_login)


        etId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            } //id 변경전
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            } //id 변경중
            override fun afterTextChanged(s: Editable?) {
            } //id 변경후
        })

        etPw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            } //pw 변경전
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            } //pw 변경중
            override fun afterTextChanged(s: Editable?) {
            } //pw 변경후
        })

        btnLogin.setOnClickListener {
            if (!id.isNullOrEmpty() && !pw.isNullOrEmpty()){ //+id,pw 확인하는 작업 추가하기
                Toast.makeText(this,"로그인되었습니다.", Toast.LENGTH_SHORT).show()
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"이메일과 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }

    }
}