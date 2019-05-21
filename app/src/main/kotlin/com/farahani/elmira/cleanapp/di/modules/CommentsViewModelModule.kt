package com.farahani.elmira.cleanapp.di.modules

import androidx.lifecycle.ViewModel
import com.farahani.elmira.presentation.details.comments.CommentsViewModel
import dagger.Module
import dagger.Provides

@Module
class CommentsViewModelModule {

    @Provides
    fun provideViewModel(viewModel: CommentsViewModel): ViewModel = viewModel
}