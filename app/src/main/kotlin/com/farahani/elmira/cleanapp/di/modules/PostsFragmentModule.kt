package com.farahani.elmira.cleanapp.di.modules

import com.farahani.elmira.presentation.posts.PostsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PostsFragmentModule {
    @ContributesAndroidInjector
    abstract fun postsFragment(): PostsFragment
}