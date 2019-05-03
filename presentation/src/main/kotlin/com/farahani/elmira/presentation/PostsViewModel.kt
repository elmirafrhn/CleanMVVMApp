package com.farahani.elmira.presentation

import androidx.lifecycle.MutableLiveData
import com.farahani.elmira.domain.usecases.GetPostsUseCaseImp
import javax.inject.Inject

class PostsViewModel @Inject constructor(private val getPostsUseCaseImp: GetPostsUseCaseImp) : BaseViewModel() {
    var postsLiveData: MutableLiveData<GetPostsViewStates> = MutableLiveData()

    fun getPosts() {
        getPostsUseCaseImp.execute()
    }
}