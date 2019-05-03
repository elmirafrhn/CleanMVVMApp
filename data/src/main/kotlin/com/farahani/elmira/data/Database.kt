package com.farahani.elmira.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farahani.elmira.data.entities.PostEntity
import com.farahani.elmira.data.entities.PostsDao
import com.farahani.elmira.data.entities.UserEntity


@Database(
    entities = [
        PostEntity::class,
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun postsDao(): PostsDao
}