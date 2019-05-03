package com.farahani.elmira.presentation

import com.farahani.elmira.domain.entities.Post
import com.farahani.elmira.presentation.models.PostModel

fun Post.map() = PostModel(
    userId = userId,
    id = id,
    title = title,
    body = body
)