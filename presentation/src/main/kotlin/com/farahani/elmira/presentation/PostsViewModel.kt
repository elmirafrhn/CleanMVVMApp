package com.farahani.elmira.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import com.farahani.elmira.domain.entities.Post
import com.farahani.elmira.domain.usecases.GetPostDetailsUseCaseFlowable
import com.farahani.elmira.domain.usecases.GetPostsUseCaseFlowable
import com.farahani.elmira.domain.usecases.GetPostsUseCaseImp
import com.farahani.elmira.presentation.models.PostModel
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    private val getPostsUseCaseImp: GetPostsUseCaseImp,
    private val getPostDetailsUseCaseFlowable: GetPostDetailsUseCaseFlowable,
    getPostsUseCaseFlowable: GetPostsUseCaseFlowable
) : BaseViewModel() {
    val postsState: MutableLiveData<GetPostsViewStates> = MutableLiveData()
    val showDetailFragmet: MutableLiveData<PostModel> = MutableLiveData()
    val posts: LiveData<MutableList<Post>> =
        LiveDataReactiveStreams.fromPublisher(getPostsUseCaseFlowable.execute(Unit))
    var loadMoreSubject =
        PublishSubject.create<PostsListAction>()

    init {
        getPostsUseCaseImp.execute()
            .subscribe({
                Log.d("getPostsUseCaseImp", "getPostsUseCaseImp")

            }, {
                Log.d("getPostsUseCaseImp", it.message)
            }).track()

        getPostsUseCaseFlowable.execute(Unit)
            .subscribe({
                Log.d("getPostsUseCaseImp", "getPostsUseCaseFlowable")
                postsState.postValue(GetPostsViewStates(showLoading = false, error = false))
            }, {
                Log.d("getPostsUseCaseImp", "getPostsUseCaseFlowableError")
                postsState.postValue(GetPostsViewStates(error = true))
            }).track()
    }

    fun handlePostsListActions() {
        loadMoreSubject.subscribe({ action ->
            when (action) {
                is PostsListAction.LoadMorePostsAction -> {
                    postsState.postValue(GetPostsViewStates(showLoading = true, error = false))
                    getPostsUseCaseImp.execute().subscribe({

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