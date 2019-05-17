package com.farahani.elmira.data.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface PostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(posts: MutableList<PostEntity>)

    @Query("Select * from posts")
    fun selectPosts(): Flowable<MutableList<PostEntity>>

    @Query("Select * from posts where id=:id")
    fun selectPostById(id: Int): Flowable<PostEntity>
}