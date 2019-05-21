package com.farahani.elmira.cleanapp.di.modules

import com.farahani.elmira.data.repositories.CommentsRepository
import com.farahani.elmira.data.repositories.PostsRepository
import com.farahani.elmira.domain.usecases.*
import com.farahani.elmira.presentation.transformer.TransformerFImpl
import com.farahani.elmira.presentation.transformer.TransformerImpl
import dagger.Module
import dagger.Provides

@Module
class UsecasesModule {

    @Provides
    fun provideGetPostsUseCase(repository: PostsRepository): GetPostsUseCase =
        GetPostsUseCase(TransformerImpl(), repository)

    @Provides
    fun provideGetPostsUseCaseF(repository: com.farahani.elmira.data.repositories.PostsRepository): GetPostsUseCaseFlowable =
        GetPostsUseCaseFlowable(repository, TransformerFImpl())

    @Provides
    fun provideGetPostDetailsUseCase(repository: com.farahani.elmira.data.repositories.PostsRepository): GetPostDetailsUseCaseFlowable =
        GetPostDetailsUseCaseFlowable(repository, TransformerFImpl())

    @Provides
    fun provideGetCommentsUseCase(repository: CommentsRepository): GetCommentsUseCase =
        GetCommentsUseCase(repository, TransformerImpl())

    @Provides
    fun provideGetCommentsUseCaseFlowable(repository: CommentsRepository): GetCommentsUseCaseFlowable =
        GetCommentsUseCaseFlowable(repository, TransformerFImpl())
}