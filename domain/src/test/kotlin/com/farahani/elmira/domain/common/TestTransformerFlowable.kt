package com.farahani.elmira.domain.common

import com.farahani.elmira.domain.TransformerFlowable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher

class TestTransformerFlowable<T> : TransformerFlowable<T>() {
    override fun apply(upstream: Flowable<T>): Publisher<T> =
        upstream.subscribeOn(Schedulers.io())
}