package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.TransformerFlowable
import com.farahani.elmira.domain.entities.Post
import com.farahani.elmira.domain.interfaces.PostsRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetPostsUseCaseFlowable @Inject constructor(
    private val postsRepository: PostsRepository,
    private val transformer: TransformerFlowable<MutableList<Post>>
) : BaseUseCaseFlowable<MutableList<Post>> {
    override fun execute(): Flowable<MutableList<Post>> =
        postsRepository.getPostsF().compose(transformer)
}