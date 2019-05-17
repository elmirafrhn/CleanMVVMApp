package com.farahani.elmira.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farahani.elmira.domain.usecases.GetPostDetailsUseCaseFlowable
import com.farahani.elmira.domain.usecases.GetPostsUseCaseFlowable
import com.farahani.elmira.domain.usecases.GetPostsUseCaseImp
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    private val useCase: GetPostsUseCaseImp,
    private val getPostDetailsUseCaseFlowable: GetPostDetailsUseCaseFlowable,
    private val getPostsUseCaseFlowable: GetPostsUseCaseFlowable
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(useCase, getPostDetailsUseCaseFlowable, getPostsUseCaseFlowable) as T
    }
}