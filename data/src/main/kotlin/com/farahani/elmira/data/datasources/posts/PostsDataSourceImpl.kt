package com.farahani.elmira.data.datasources.posts

import android.util.Log
import com.farahani.elmira.data.api.ApiService
import com.farahani.elmira.data.entities.PostEntity
import com.farahani.elmira.data.entities.PostsDao
import com.farahani.elmira.data.map
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class PostsDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val postsDao: PostsDao
) : PostsDataSource {
    override fun getPosts(): Completable =
        apiService.getPosts().doOnComplete {
            getPostsFromRemote()
        }.doOnError {
            Log.d("onError", it.message)
        }.ignoreElements()

    private fun getPostsFromRemote(): Disposable =
        apiService.getPosts().subscribe({
            persistPosts(it.map { item -> item.map() })
        }, { throwable ->
            Log.d("getPostsError", throwable.message)
        })

    private fun persistPosts(list: List<PostEntity>) =
        postsDao.insertPosts(list)
}