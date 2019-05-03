package com.farahani.elmira.cleanapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farahani.elmira.presentation.PostsViewModel
import com.farahani.elmira.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PostsViewModelModule {

    @Provides
    fun provideViewModel(viewModel: PostsViewModel): ViewModel = viewModel

    @Provides
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory = factory

}