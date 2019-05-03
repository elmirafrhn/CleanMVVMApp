package com.farahani.elmira.data.datasources.posts

import io.reactivex.Completable

interface PostsDataSource {

    fun getPosts(): Completable
}