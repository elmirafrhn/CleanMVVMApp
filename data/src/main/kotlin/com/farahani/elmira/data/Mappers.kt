package com.farahani.elmira.data

import com.farahani.elmira.data.dto.CommentDto
import com.farahani.elmira.data.dto.PostDto
import com.farahani.elmira.data.entities.CommentEntity
import com.farahani.elmira.data.entities.PostEntity
import com.farahani.elmira.domain.entities.Comment
import com.farahani.elmira.domain.entities.Post

fun PostEntity.map() = Post(
    userId = userId,
    id = id,
    title = title,
    body = body
)

fun PostDto.map() = PostEntity(
    userId = userId,
    id = id,
    title = title,
    body = body
)

fun Post.map() = PostEntity(
    userId = userId,
    id = id,
    title = title,
    body = body
)

fun CommentDto.map() = CommentEntity(
    postId = postId,
    id = id,
    body = body,
    email = email,
    name = name
)

fun CommentEntity.map() = Comment(
    postId = postId,
    id = id,
    name = name,
    email = email,
    body = body
)
