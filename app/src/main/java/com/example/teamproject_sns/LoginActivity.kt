package com.example.teamproject_sns

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText

import android.widget.TextView
import android.widget.Toast

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts


class LoginActivity : AppCompatActivity() {


    private lateinit var et_name:TextView

    private lateinit var etId:EditText
    private lateinit var etPw:EditText

    //회원가입 결과 콜백변수 초기화
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //name =>로그인단에서는 보여지지 않게끔 ui조정
        et_name = findViewById(R.id.et_name)


        //email
        etId = findViewById(R.id.et_email)

        //password
        etPw = findViewById(R.id.et_pw)

        //회원가입 결과처리 설정
        setResultFromSignUp()


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
            val name = et_name.text.toString().trim()
            val id = etId.text.toString().trim()
            val pw = etPw.text.toString().trim()
            if (name.isNotEmpty()&& id.isNotEmpty() && pw.isNotEmpty()){ //+id,pw 확인하는 작업 추가하기
                Toast.makeText(this,"로그인되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)

                //name은 회원가입버튼 누를때 넘어옴
                intent.putExtra("name",name)
                intent.putExtra("email",id)
                intent.putExtra("password",pw)


                startActivity(intent)
            } else if(name.isEmpty()){
                Toast.makeText(this,"이름을 확인해주세요", Toast.LENGTH_SHORT).show()
                Log.d("emptyfiled",name)
            }else if(id.isEmpty()){
                Toast.makeText(this,"아이디가 empty",Toast.LENGTH_SHORT).show()
                Log.d("emptyfiled",id)
            }else{
                Toast.makeText(this," pw가 empty",Toast.LENGTH_SHORT).show()
                Log.d("emptyfiled",pw)
            }
        }

        val signup = findViewById<Button>(R.id.signup)
        signup.setOnClickListener {
            //회원가입 화면 이동
               val intent = Intent(this,JoinActivity::class.java)

                resultLauncher.launch(intent)
        }
    }



    //회원가입으로부터 데이터 받을때
    private fun setResultFromSignUp() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == Activity.RESULT_OK){
                val data: Intent? = result.data
                data?.let{
                    val name = it.getStringExtra("name") ?: ""
                    val email = it.getStringExtra("email") ?: ""
                    val password = it.getStringExtra("password") ?: ""

                    et_name.text = name
                    etId.setText(email)
                    etPw.setText(password)

                }
            }
        }
    }
}