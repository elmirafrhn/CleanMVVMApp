package com.farahani.elmira.data.api

import com.farahani.elmira.data.dto.PostDto
import io.reactivex.Flowable
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiServiceImpl @Inject constructor(retrofit: Retrofit) : ApiService {
    private val retrofitCreated = retrofit.create(ApiService::class.java)
    override fun getPosts(page:Int,limit:Int): Flowable<MutableList<PostDto>> = retrofitCreated.getPosts(page,limit)
}