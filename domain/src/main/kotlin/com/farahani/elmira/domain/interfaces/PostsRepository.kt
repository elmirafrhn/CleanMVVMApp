package com.farahani.elmira.domain.interfaces

import com.farahani.elmira.domain.entities.Post
import io.reactivex.Completable
import io.reactivex.Flowable

interface PostsRepository : BaseRepository {

    fun loadMorePosts(): Completable
    fun getPostsF(): Flowable<MutableList<Post>>
    fun getPostDetails(id: Int): Flowable<Post>
}