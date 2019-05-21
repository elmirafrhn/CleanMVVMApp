package com.farahani.elmira.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farahani.elmira.data.entities.*


@Database(
    entities = [
        PostEntity::class,
        CommentEntity::class,
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun postsDao(): PostsDao
    abstract fun commentsDao(): CommentsDao
}