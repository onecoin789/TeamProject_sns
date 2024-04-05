package com.example.teamproject_sns

import android.graphics.Color
import android.widget.EditText
import java.util.regex.Pattern

interface checkValidation {
    fun checkValidation(name: String, email: String, password: String): Int {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            // Toast.makeText(this@activity, "유효한 이메일을 입력하세요", Toast.LENGTH_SHORT).show()
            return 2
        }
        if (!email.matches(emailPattern.toRegex()))
            return 3
        if (password.length < 8 || !password.contains(Regex("[A-Z]"))
            || !password.contains(Regex("[^A-Za-z0-9]")))
            return 4
        return 1
    }
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
    fun checkConfirmPw(pw:EditText,confirmpw:EditText): Boolean{
        val pwText = pw.text.toString().trim()
        val confirmpwText = confirmpw.text.toString().trim()
        if (pwText == confirmpwText) {
            return true
            pw.setTextColor(Color.parseColor("#000000"))
        }
        else {
            return false
            pw.setTextColor(Color.parseColor("#D32222"))

        }
    }

    fun checkNull(text: String): Boolean {
        if (text.isNullOrEmpty()){
            return false
        } else
            return true
    }
}

