package com.farahani.elmira.presentation.details.comments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.farahani.elmira.domain.usecases.GetCommentsUseCase
import com.farahani.elmira.domain.usecases.GetCommentsUseCaseFlowable
import com.farahani.elmira.presentation.common.BaseViewModel
import com.farahani.elmira.presentation.common.utils.map
import com.farahani.elmira.presentation.models.CommentModel
import com.farahani.elmira.presentation.models.PostModel
import javax.inject.Inject

class CommentsViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase,
    private val getCommentsUseCaseFlowable: GetCommentsUseCaseFlowable
) : BaseViewModel() {

    val postLiveData = MutableLiveData<PostModel>()
    var comments: LiveData<List<CommentModel>>? = null

    init {

        comments = Transformations.switchMap(postLiveData) {
            it.apply {
                getCommentsUseCase.execute(it.id).subscribe({
                    Log.d("comments", "getComments")
                },
                    {
                        Log.d("comments error", it.message)
                    }
                ).track()

                getCommentsUseCaseFlowable.execute(it.id).subscribe({
                }, { throwable ->
                    Log.d("comments F error", throwable.message)
                }).track()
            }
            LiveDataReactiveStreams.fromPublisher(getCommentsUseCaseFlowable.execute(it.id).map { comments ->
                comments.map { item ->
                    item.map()
                }
            })

        }

    }


    fun setPostId(post: PostModel) {
        postLiveData.postValue(post)
    }
}