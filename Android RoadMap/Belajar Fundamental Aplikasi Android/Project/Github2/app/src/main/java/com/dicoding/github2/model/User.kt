package com.dicoding.github2.model

data class User(
        var Name: String ="",
        var Username: String = "",
        var Location: String = "",
        var Repository: Int= 0,
        var Company: String = "",
        var Followers: Int = 0,
        var Following: Int = 0,
        var Avatar: String = ""
)