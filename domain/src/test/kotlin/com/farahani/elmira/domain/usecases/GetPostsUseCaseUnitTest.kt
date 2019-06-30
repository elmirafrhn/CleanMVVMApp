package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.common.TestTransformer
import com.farahani.elmira.domain.interfaces.PostsRepository
import io.reactivex.Completable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.mockito.Mockito.`when`

@RunWith(JUnit4::class)
class GetPostsUseCaseUnitTest {

    private val repository: PostsRepository = Mockito.mock(PostsRepository::class.java)
    private val loadMorePosts = GetPostsUseCase(TestTransformer(), repository)

    @Test
    fun `success execute`() {
        `when`(repository.loadMorePosts()).thenReturn(Completable.complete())
        loadMorePosts.execute(Unit)
            .test()
            .assertComplete()
    }
}