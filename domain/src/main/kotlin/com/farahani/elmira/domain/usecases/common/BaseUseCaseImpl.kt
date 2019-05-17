package com.farahani.elmira.domain.usecases.common

import com.farahani.elmira.domain.Transformer
import com.farahani.elmira.domain.usecases.common.BaseUseCase

abstract class BaseUseCaseImpl<T>(private val transformer: Transformer) :
    BaseUseCase {

//    abstract fun createObservable(): Observable<T>
//
//    fun observable(): Observable<T> {
//        return createObservable().compose(transformer)
//    }
}