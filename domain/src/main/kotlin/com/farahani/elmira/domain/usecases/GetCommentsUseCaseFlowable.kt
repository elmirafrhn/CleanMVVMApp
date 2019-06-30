package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.TransformerFlowable
import com.farahani.elmira.domain.entities.Comment
import com.farahani.elmira.domain.interfaces.CommentsRepository
import com.farahani.elmira.domain.usecases.common.BaseUseCaseFlowable
import io.reactivex.Flowable
import javax.inject.Inject

class GetCommentsUseCaseFlowable @Inject constructor(
    private val repository: CommentsRepository,
    private val transformer: TransformerFlowable<List<Comment>>
) : BaseUseCaseFlowable<Int, List<Comment>>() {

    override fun execute(arg: Int): Flowable<List<Comment>> = repository.loadComments(arg).compose(transformer)
}