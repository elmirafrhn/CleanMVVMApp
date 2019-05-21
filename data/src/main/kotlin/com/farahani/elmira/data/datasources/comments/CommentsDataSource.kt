package com.farahani.elmira.data.datasources.comments

import com.farahani.elmira.data.entities.CommentEntity
import io.reactivex.Completable
import io.reactivex.Flowable

interface CommentsDataSource {

    fun getComments(id: Int): Completable
    fun loadComments(id: Int): Flowable<List<CommentEntity>>
}