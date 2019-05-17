package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.TransformerFlowable
import com.farahani.elmira.domain.entities.Post
import com.farahani.elmira.domain.interfaces.PostsRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetPostsUseCaseFlowable @Inject constructor(
    private val postsRepository: PostsRepository,
    private val transformer: TransformerFlowable<MutableList<Post>>
) : BaseUseCaseFlowable<Unit, MutableList<Post>>() {
    override fun execute(arg: Unit): Flowable<MutableList<Post>> =
        postsRepository.getPostsF().compose(transformer)
}