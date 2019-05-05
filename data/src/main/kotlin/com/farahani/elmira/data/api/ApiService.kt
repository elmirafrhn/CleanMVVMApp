package com.farahani.elmira.data.api

import com.farahani.elmira.data.dto.PostDto
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getPosts(): Flowable<MutableList<PostDto>>
}