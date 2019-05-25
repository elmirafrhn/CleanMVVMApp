package com.farahani.elmira.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import com.farahani.elmira.domain.entities.Post
import com.farahani.elmira.domain.usecases.GetPostDetailsUseCaseFlowable
import com.farahani.elmira.domain.usecases.GetPostsUseCase
import com.farahani.elmira.domain.usecases.GetPostsUseCaseFlowable
import com.farahani.elmira.presentation.models.PostModel
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val getPostDetailsUseCaseFlowable: GetPostDetailsUseCaseFlowable,
    getPostsUseCaseFlowable: GetPostsUseCaseFlowable
) : BaseViewModel() {
    val postsState: MutableLiveData<GetPostsViewStates> = MutableLiveData()
    val showDetailFragmet: MutableLiveData<PostModel> = MutableLiveData()
    val posts: LiveData<List<PostModel>> =
        LiveDataReactiveStreams.fromPublisher(getPostsUseCaseFlowable.execute(Unit).map {
            it.map { it.map() }
        })
    var loadMoreSubject =
        PublishSubject.create<PostsListAction>()

    init {
        getPostsUseCase.execute(Unit)
            .subscribe({
                Log.d("getPostsUseCase", "getPostsUseCase")

            }, {
                Log.d("getPostsUseCase", it.message)
            }).track()

        getPostsUseCaseFlowable.execute(Unit)
            .subscribe({
                Log.d("getPostsUseCase", "getPostsUseCaseFlowable")
                postsState.postValue(GetPostsViewStates(showLoading = false, error = false))
            }, {
                Log.d("getPostsUseCase", "getPostsUseCaseFlowableError")
                postsState.postValue(GetPostsViewStates(error = true))
            }).track()
    }

    fun handlePostsListActions() {
        loadMoreSubject.subscribe({ action ->
            when (action) {
                is PostsListAction.LoadMorePostsAction -> {
                    postsState.postValue(GetPostsViewStates(showLoading = true, error = false))
                    getPostsUseCase.execute(Unit).subscribe({

                        Log.d("getPosts", "loadmore")
                        postsState.postValue(GetPostsViewStates(showLoading = false, error = false))

                    }, {
                        Log.d("getPosts", it.message)
                    }).track()
                }
                is PostsListAction.PostsListItemAction -> {
                    getPostDetailsUseCaseFlowable.execute(action.postModel.id).subscribe({

                        Log.d("getPostDetails", it.body)
                        showDetailFragmet.postValue(it.map())

                    }, {
                        Log.d("getPostDetails", it.message)
                    }).track()
                }
                else -> {

                }
            }
        }, {
            Log.d("getPosts subject", it.message)
        }).track()
    }
}