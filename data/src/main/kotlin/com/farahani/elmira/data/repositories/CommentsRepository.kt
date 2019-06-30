package com.farahani.elmira.data.repositories

import com.farahani.elmira.data.datasources.comments.CommentsDataSource
import com.farahani.elmira.data.map
import com.farahani.elmira.domain.entities.Comment
import com.farahani.elmira.domain.interfaces.CommentsRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class CommentsRepository @Inject constructor(
    private val dataSource: CommentsDataSource
) : CommentsRepository {

    override fun getComments(id: Int): Completable = dataSource.getComments(id)

    override fun loadComments(id: Int): Flowable<List<Comment>> =
        dataSource.loadComments(id).map {
            it.map { item ->
                item.map()
            }
        }
}
