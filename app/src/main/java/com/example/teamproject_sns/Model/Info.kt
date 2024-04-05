package com.example.teamproject_sns.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Info(
    // val profileImg: Uri,
    val name: String,
    val email: String,
    val password: String) : Parcelable