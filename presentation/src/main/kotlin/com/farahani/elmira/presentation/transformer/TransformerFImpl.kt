package com.farahani.elmira.presentation.transformer

import com.farahani.elmira.domain.TransformerFlowable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher
import javax.inject.Inject

class TransformerFImpl<T> @Inject constructor() : TransformerFlowable<T>() {
    override fun apply(upstream: Flowable<T>): Publisher<T> =
        upstream.subscribeOn(Schedulers.io())
}
