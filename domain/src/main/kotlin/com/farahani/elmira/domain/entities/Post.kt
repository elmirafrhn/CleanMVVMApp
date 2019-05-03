package com.farahani.elmira.domain.entities

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)