package com.farahani.elmira.cleanapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farahani.elmira.cleanapp.di.ViewModelFactory
import com.farahani.elmira.cleanapp.di.ViewModelKey
import com.farahani.elmira.presentation.PostsViewModel
import com.farahani.elmira.presentation.details.comments.CommentsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    internal abstract fun bindPostsViewModel(viewModel: PostsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CommentsViewModel::class)
    internal abstract fun bindCommentsViewModel(viewModel: CommentsViewModel): ViewModel
}