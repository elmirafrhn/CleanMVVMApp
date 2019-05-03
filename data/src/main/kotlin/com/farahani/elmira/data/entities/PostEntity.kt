package com.farahani.elmira.data.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)