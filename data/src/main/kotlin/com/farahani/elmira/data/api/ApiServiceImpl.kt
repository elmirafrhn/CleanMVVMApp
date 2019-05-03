package com.farahani.elmira.data.api

import com.farahani.elmira.data.dto.PostDto
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val retrofit: Retrofit) : ApiService {
    private val retrofitCreated = retrofit.create(ApiService::class.java)
    override fun getPosts(): Observable<List<PostDto>> = retrofitCreated.getPosts()


}