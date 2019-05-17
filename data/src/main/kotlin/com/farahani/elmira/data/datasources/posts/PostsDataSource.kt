package com.farahani.elmira.data.datasources.posts

import com.farahani.elmira.data.entities.PostEntity
import io.reactivex.Completable
import io.reactivex.Flowable

interface PostsDataSource {

    fun loadMorePosts(): Completable
    fun getPostsF(): Flowable<MutableList<PostEntity>>
    fun getPostDetails(id: Int): Flowable<PostEntity>
}