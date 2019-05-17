package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.Transformer
import com.farahani.elmira.domain.interfaces.PostsRepository
import io.reactivex.Completable

class GetPostsUseCaseImp(
    private val transformer: Transformer,
    private val postsRepository: PostsRepository
) : GetPostsUseCase {
    override fun execute(): Completable =
        postsRepository.loadMorePosts().compose(transformer)
}