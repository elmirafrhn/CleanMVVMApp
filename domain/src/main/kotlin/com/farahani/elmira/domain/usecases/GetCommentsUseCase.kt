package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.Transformer
import com.farahani.elmira.domain.interfaces.CommentsRepository
import com.farahani.elmira.domain.usecases.common.BaseUseCase
import io.reactivex.Completable
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
    private val repository: CommentsRepository,
    private val transformer: Transformer
) : BaseUseCase<Int>(){
    override fun execute(arg:Int): Completable = repository.getComments(arg).compose(transformer)
}