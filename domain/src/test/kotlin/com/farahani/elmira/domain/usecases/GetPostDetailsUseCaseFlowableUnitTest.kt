package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.common.TestTransformerFlowable
import com.farahani.elmira.domain.common.TestUtils
import com.farahani.elmira.domain.interfaces.PostsRepository
import io.reactivex.Flowable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class GetPostDetailsUseCaseFlowableUnitTest {

    private val repository: PostsRepository = Mockito.mock(PostsRepository::class.java)
    private val getPostsF = GetPostsUseCaseFlowable(repository, TestTransformerFlowable())

    @Test
    fun `success execute`() {

        Mockito.`when`(repository.getPostsF()).thenReturn(Flowable.just(TestUtils.PostObject()))

        getPostsF.execute(Unit)
            .test()
            .assertValue()
            .assertComplete()
    }
}