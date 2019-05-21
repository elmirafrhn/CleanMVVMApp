package com.farahani.elmira.domain.interfaces

import com.farahani.elmira.domain.entities.Comment
import io.reactivex.Completable
import io.reactivex.Flowable

interface CommentsRepository : BaseRepository {

    fun getComments(id:Int): Completable
    fun loadComments(id: Int): Flowable<List<Comment>>
}