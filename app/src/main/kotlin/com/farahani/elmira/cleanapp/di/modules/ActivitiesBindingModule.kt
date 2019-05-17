package com.farahani.elmira.cleanapp.di.modules

import com.farahani.elmira.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [PostsFragmentModule::class,
        DetailsFragmentModule::class]
)
abstract class ActivitiesBindingModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}