package com.example.teamproject_sns

import android.widget.Toast

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
}

