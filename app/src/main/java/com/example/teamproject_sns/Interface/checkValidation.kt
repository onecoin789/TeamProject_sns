package com.example.teamproject_sns

import android.graphics.Color
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat.getColor
import java.util.regex.Pattern

interface checkValidation {
    //이메일 유효성 검사
    fun checkEmail(id: EditText): Boolean {
        val email = id.text.toString().trim()
        val emailPattern = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if (emailPattern) {
            id.setTextColor(Color.parseColor("#000000"))
            return true
        } else {
            id.setTextColor(Color.parseColor("#D32222"))
            return false
        }
    }

    //비밀번호 유효성 검사 : 8~20자 영문 + 숫자
    fun checkPw(pw: EditText): Boolean {
        val pwText = pw.text.toString().trim()
        val pwPattern = Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{8,20}$", pwText)
        if (pwPattern) {
            pw.setTextColor(Color.parseColor("#000000"))
            return true
        } else {
            pw.setTextColor(Color.parseColor("#D32222"))
            return false
        }
    }

    fun checkNull(text: String): Boolean {
        if (text.isNullOrEmpty()){
            return false
        } else return true
    }
}

