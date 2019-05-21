package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.TransformerFlowable
import com.farahani.elmira.domain.entities.Post
import com.farahani.elmira.domain.interfaces.PostsRepository
import com.farahani.elmira.domain.usecases.common.BaseUseCaseFlowable
import io.reactivex.Flowable
import javax.inject.Inject

class GetPostDetailsUseCaseFlowable @Inject constructor(
    private val postsRepository: PostsRepository,
    private val transformer: TransformerFlowable<Post>
) : BaseUseCaseFlowable<Int, Post>() {
    override fun execute(arg: Int): Flowable<Post> =
        postsRepository.getPostDetails(arg).compose(transformer)
}