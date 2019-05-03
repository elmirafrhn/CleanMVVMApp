package com.farahani.elmira.data.dto

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

class UserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String
)