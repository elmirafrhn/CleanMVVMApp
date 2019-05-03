package com.farahani.elmira.data.repositories

import com.farahani.elmira.data.datasources.posts.PostsDataSource
import com.farahani.elmira.domain.interfaces.PostsRepository
import io.reactivex.Completable
import javax.inject.Inject

class PostsRepository @Inject constructor(private val postsDataSource: PostsDataSource) : PostsRepository {
    override fun getPosts(): Completable {
        return postsDataSource.getPosts()
    }
}