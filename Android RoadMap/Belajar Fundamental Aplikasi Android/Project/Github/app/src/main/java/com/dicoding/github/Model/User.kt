package com.dicoding.github.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var Username: String,
    var Name: String,
    var Location: String,
    var Repository: Int,
    var Company: String,
    var Followers: Int,
    var Following: Int,
    var Avatar: Int
): Parcelable
