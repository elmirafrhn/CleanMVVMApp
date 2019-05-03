package com.farahani.elmira.data.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface PostsDao {

    @Insert
    fun insertPosts(posts: List<PostEntity>)

    @Query("Select * from posts")
    fun selectPosts(): Flowable<List<PostEntity>>
}