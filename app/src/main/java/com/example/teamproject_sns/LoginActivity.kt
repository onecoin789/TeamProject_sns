package com.example.teamproject_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etId = findViewById<EditText>(R.id.et_email)
        val etPw = findViewById<EditText>(R.id.et_pw)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        val emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

        //이메일 유효성 검사하는 함수
        fun checkEmail():Boolean{
            var email = etId.text.toString().trim() //공백제거
            val checkEmail = Pattern.matches(emailValidation, email)
            if (checkEmail) {
                etId.setTextColor(getColor(R.color.black))
                return true
            } else {
                etId.setTextColor(getColor(R.color.red))
                return false
            }
        }

        //해당하는 아이디와 비밀번호 있는지 확인하는 함수
        fun checkPw() :Boolean{
            val pw = etPw.text.toString()
            if (!pw.isNullOrEmpty()){
                return true
            } else return false
        }

        etId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            } //id 변경전
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            } //id 변경중
            override fun afterTextChanged(s: Editable?) {
                checkEmail()
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
            if (etId.text.isNullOrEmpty()||etPw.text.isNullOrEmpty()){
                Toast.makeText(this, resources.getString(R.string.toast_noInput),Toast.LENGTH_SHORT).show()
            } else if(!checkEmail()){
                Toast.makeText(this, resources.getString(R.string.toast_email),Toast.LENGTH_SHORT).show()
            } else if(!checkPw()){
                Toast.makeText(this, resources.getString(R.string.toast_pw),Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,resources.getString(R.string.toast_login), Toast.LENGTH_SHORT).show()
                intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("id", etId.text.toString()) //data class 생성후에 수정하겠습니다.
                    putExtra("pw", etPw.text.toString())
                }
                startActivity(intent)
            }
        }

    }
}