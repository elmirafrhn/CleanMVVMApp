package com.farahani.elmira.domain.usecases

import io.reactivex.Flowable

interface  BaseUseCaseFlowable<R> {
    fun execute(): Flowable<R>
}