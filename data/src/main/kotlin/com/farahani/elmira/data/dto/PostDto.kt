package com.farahani.elmira.data.dto


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

class PostDto(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)