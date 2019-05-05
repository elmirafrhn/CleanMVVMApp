package com.farahani.elmira.data.repositories

import com.farahani.elmira.data.datasources.posts.PostsDataSource
import com.farahani.elmira.data.map
import com.farahani.elmira.domain.entities.Post
import com.farahani.elmira.domain.interfaces.PostsRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val postsDataSource: PostsDataSource) : PostsRepository {
    override fun getPostsF(): Flowable<MutableList<Post>> {
        return postsDataSource.getPostsF().map {
            it.map { item ->
                item.map()
            }.toMutableList()
        }
    }

    override fun getPosts(): Completable {
        return postsDataSource.getPosts()
    }
}