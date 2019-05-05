package com.farahani.elmira.cleanapp.di.modules

import com.farahani.elmira.data.repositories.PostsRepositoryImpl
import com.farahani.elmira.domain.interfaces.PostsRepository
import com.farahani.elmira.domain.usecases.GetPostsUseCase
import com.farahani.elmira.domain.usecases.GetPostsUseCaseFlowable
import com.farahani.elmira.domain.usecases.GetPostsUseCaseImp
import com.farahani.elmira.presentation.transformer.TransformerFImpl
import com.farahani.elmira.presentation.transformer.TransformerImpl
import dagger.Module
import dagger.Provides

@Module
class UsecasesModule {

    @Provides
    fun provideGetPostsUseCaseImp(repository: PostsRepository): GetPostsUseCaseImp =
        GetPostsUseCaseImp(TransformerImpl(), repository)

    @Provides
    fun provideGetPostsUseCaseFImpl(repository: PostsRepositoryImpl): GetPostsUseCaseFlowable =
        GetPostsUseCaseFlowable(repository, TransformerFImpl())
}