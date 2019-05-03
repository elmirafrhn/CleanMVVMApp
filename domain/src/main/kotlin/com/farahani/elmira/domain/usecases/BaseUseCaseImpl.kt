package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.Transformer
import io.reactivex.Observable

abstract class BaseUseCaseImpl<T>(private val transformer: Transformer) : BaseUseCase {

//    abstract fun createObservable(): Observable<T>
//
//    fun observable(): Observable<T> {
//        return createObservable().compose(transformer)
//    }
}