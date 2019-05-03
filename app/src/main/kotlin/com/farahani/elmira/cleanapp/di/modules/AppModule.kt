package com.farahani.elmira.cleanapp.di.modules

import android.content.Context
import com.farahani.elmira.cleanapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: App): Context = app.applicationContext
}