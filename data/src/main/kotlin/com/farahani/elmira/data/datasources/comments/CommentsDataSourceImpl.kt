package com.farahani.elmira.data.datasources.comments

import com.farahani.elmira.data.api.ApiService
import com.farahani.elmira.data.entities.CommentsDao
import com.farahani.elmira.data.entities.CommentEntity
import com.farahani.elmira.data.map
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class CommnetsDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val commentDao: CommentsDao
) : CommentsDataSource {

    private val page = 1
    private val limit = 10

    override fun getComments(id:Int): Completable = getAndPersistComments(id)

    override fun loadComments(id: Int): Flowable<List<CommentEntity>> = commentDao.selectComments(id)

    private fun getAndPersistComments(id: Int): Completable {
        return apiService.getComments(id, page, limit)
            .doOnNext {
                commentDao.insert(it.map { item -> item.map() })
            }.ignoreElements()
    }
}