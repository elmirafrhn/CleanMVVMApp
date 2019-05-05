package com.farahani.elmira.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import com.farahani.elmira.domain.entities.Post
import com.farahani.elmira.domain.usecases.GetPostsUseCaseFlowable
import com.farahani.elmira.domain.usecases.GetPostsUseCaseImp
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    private val getPostsUseCaseImp: GetPostsUseCaseImp,
    private val getPostsUseCaseFlowable: GetPostsUseCaseFlowable
) : BaseViewModel() {
    val postsLiveData: MutableLiveData<GetPostsViewStates> = MutableLiveData()
    val posts: LiveData<MutableList<Post>> = LiveDataReactiveStreams.fromPublisher(getPostsUseCaseFlowable.execute())

    init {
        getPostsUseCaseImp.execute()
            .subscribe({
                Log.d("getPostsUseCaseImp", "getPostsUseCaseImp")
            }, {
                Log.d("getPostsUseCaseImp", it.message)
            }).track()

        getPostsUseCaseFlowable.execute()
            .subscribe({
                Log.d("getPostsUseCaseImp", "getPostsUseCaseFlowable")
            }, {
                Log.d("getPostsUseCaseImp", "getPostsUseCaseFlowableError")
            }).track()
    }
}