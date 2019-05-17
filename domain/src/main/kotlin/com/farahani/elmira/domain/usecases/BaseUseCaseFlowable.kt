package com.farahani.elmira.domain.usecases

import io.reactivex.Flowable

abstract class BaseUseCaseFlowable<A,R> {
    abstract fun execute(arg:A): Flowable<R>
}