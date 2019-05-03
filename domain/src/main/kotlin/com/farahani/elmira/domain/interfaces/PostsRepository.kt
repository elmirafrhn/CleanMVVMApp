package com.farahani.elmira.domain.interfaces

import io.reactivex.Completable

interface PostsRepository : BaseRepository {

    fun getPosts(): Completable
}