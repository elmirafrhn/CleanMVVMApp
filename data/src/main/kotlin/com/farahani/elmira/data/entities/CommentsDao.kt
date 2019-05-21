package com.farahani.elmira.data.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface CommentsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comments: List<CommentEntity>)

    @Query("select * from comments where postId=:id")
    fun selectComments(id: Int): Flowable<List<CommentEntity>>
}