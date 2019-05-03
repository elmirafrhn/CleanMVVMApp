package com.farahani.elmira.presentation.transformer

import com.farahani.elmira.domain.Transformer
import io.reactivex.Completable
import io.reactivex.CompletableSource
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TransformerImpl @Inject constructor() : Transformer() {
    override fun apply(upstream: Completable): CompletableSource =
        upstream.subscribeOn(Schedulers.io())
}