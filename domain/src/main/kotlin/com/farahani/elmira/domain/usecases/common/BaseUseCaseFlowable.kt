package com.farahani.elmira.domain.usecases.common

import io.reactivex.Flowable

abstract class BaseUseCaseFlowable<A,R> {
    abstract fun execute(arg:A): Flowable<R>
}