package com.farahani.elmira.data.api

import com.farahani.elmira.data.dto.CommentDto
import com.farahani.elmira.data.dto.PostDto
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("posts")
    fun getPosts(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): Flowable<MutableList<PostDto>>

    @GET("comments")
    fun getComments(
        @Query("postId") postId: Int,
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): Flowable<List<CommentDto>>

}