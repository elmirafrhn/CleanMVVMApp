package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.Transformer
import com.farahani.elmira.domain.interfaces.PostsRepository
import com.farahani.elmira.domain.usecases.common.BaseUseCase
import io.reactivex.Completable
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val transformer: Transformer,
    private val postsRepository: PostsRepository
) : BaseUseCase<Unit>() {
    override fun execute(arg: Unit): Completable =
        postsRepository.loadMorePosts().compose(transformer)
}