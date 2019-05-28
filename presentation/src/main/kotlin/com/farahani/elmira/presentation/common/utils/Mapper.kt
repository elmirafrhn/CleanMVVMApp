package com.farahani.elmira.presentation.common.utils

import com.farahani.elmira.domain.entities.Comment
import com.farahani.elmira.domain.entities.Post
import com.farahani.elmira.presentation.models.CommentModel
import com.farahani.elmira.presentation.models.PostModel

fun Post.map() = PostModel(
    userId = userId,
    id = id,
    title = title,
    body = body
)

fun Comment.map() = CommentModel(
    postId = postId,
    id = id,
    body = body,
    email = email,
    name = name
)