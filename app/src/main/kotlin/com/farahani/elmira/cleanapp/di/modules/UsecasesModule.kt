package com.farahani.elmira.cleanapp.di.modules

import com.farahani.elmira.data.repositories.PostsRepository
import com.farahani.elmira.domain.usecases.GetPostsUseCaseImp
import com.farahani.elmira.presentation.transformer.TransformerImpl
import dagger.Module
import dagger.Provides

@Module
class UsecasesModule {

    @Provides
    fun provideGetPostsUseCaseImp(repository: PostsRepository): GetPostsUseCaseImp =
        GetPostsUseCaseImp(TransformerImpl(), repository)
}