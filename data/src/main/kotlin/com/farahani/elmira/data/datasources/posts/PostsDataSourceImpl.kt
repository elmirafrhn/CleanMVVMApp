package com.farahani.elmira.data.datasources.posts

import com.farahani.elmira.data.api.ApiService
import com.farahani.elmira.data.entities.PostEntity
import com.farahani.elmira.data.entities.PostsDao
import com.farahani.elmira.data.map
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class PostsDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val postsDao: PostsDao
) : PostsDataSource {
    override fun getPostsF(): Flowable<MutableList<PostEntity>> {
        return getPostsFromDB()
    }

    override fun getPosts(): Completable {
        return getAndPersistPosts()
    }

    private fun getPostsFromDB(): Flowable<MutableList<PostEntity>> {
        return postsDao.selectPosts()
    }

    private fun getAndPersistPosts(): Completable {
        return apiService.getPosts()
            .doOnNext {
                postsDao.insertPosts(it.map { it.map() }.toMutableList())
            }
            .ignoreElements()
    }

}

