package com.farahani.elmira.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farahani.elmira.domain.usecases.GetPostsUseCaseImp
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val useCase: GetPostsUseCaseImp
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(useCase) as T
    }
}