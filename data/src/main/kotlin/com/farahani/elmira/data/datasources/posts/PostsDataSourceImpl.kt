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
    override fun getPostDetails(id: Int): Flowable<PostEntity> {
        return getPostDetailsFromDB(id)
    }

    private var page = 1
    private val limit = 10

    override fun getPostsF(): Flowable<MutableList<PostEntity>> = getPostsFromDB()

    override fun loadMorePosts(): Completable = getAndPersistPosts()

    private fun getPostsFromDB(): Flowable<MutableList<PostEntity>> = postsDao.selectPosts()

    private fun getAndPersistPosts(): Completable {
        return apiService.getPosts(page, limit)
            .doOnNext {
                postsDao.insertPosts(it.map { item -> item.map() }.toMutableList())
                page++
            }
            .ignoreElements()
    }

    private fun getPostDetailsFromDB(id: Int): Flowable<PostEntity> =
        postsDao.selectPostById(id)
}

