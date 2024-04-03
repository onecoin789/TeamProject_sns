package com.example.teamproject_sns

import java.io.Serializable


data class UserInfo(
    val mail: String = "",
    val password: String = "",
    val name: String = ""
) : Serializable
