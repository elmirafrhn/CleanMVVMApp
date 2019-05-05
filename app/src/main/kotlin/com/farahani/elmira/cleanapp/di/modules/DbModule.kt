package com.farahani.elmira.cleanapp.di.modules

import android.content.Context
import androidx.room.Room
import com.farahani.elmira.data.Database
import com.farahani.elmira.data.api.ApiService
import com.farahani.elmira.data.datasources.posts.PostsDataSource
import com.farahani.elmira.data.datasources.posts.PostsDataSourceImpl
import com.farahani.elmira.data.entities.PostsDao
import com.farahani.elmira.data.repositories.PostsRepositoryImpl
import com.farahani.elmira.domain.interfaces.PostsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    fun providePostsDao(db: Database) = db.postsDao()

    @Provides
    fun providePostsDataSource(apiService: ApiService, postsDao: PostsDao): PostsDataSource =
        PostsDataSourceImpl(apiService, postsDao)

    @Provides
    fun providePostsRepository(postsDataSource: PostsDataSource): PostsRepository =
        PostsRepositoryImpl(postsDataSource)

    @Provides
    @Singleton
    fun dbProvider(context: Context): Database = Room.databaseBuilder(
        context.applicationContext,
        Database::class.java,
        "posts_db"
    ).build()

//    fun getDatabase(context: Context): WordRoomDatabase {
//        if (INSTANCE == null) {
//            synchronized(WordRoomDatabase::class.java) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.getApplicationContext(),
//                        WordRoomDatabase::class.java!!,
//                        "word_database"
//                    ).addCallback(sRoomDatabaseCallback).build()
//                }
//            }
//        }
//        return INSTANCE
//    }

}