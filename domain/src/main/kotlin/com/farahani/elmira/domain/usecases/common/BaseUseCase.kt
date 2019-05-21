package com.farahani.elmira.domain.usecases.common

import io.reactivex.Completable

abstract class BaseUseCase<A> {
    abstract fun execute(arg:A): Completable
}