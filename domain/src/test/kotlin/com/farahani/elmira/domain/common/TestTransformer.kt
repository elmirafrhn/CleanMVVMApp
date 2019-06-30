package com.farahani.elmira.domain.common

import com.farahani.elmira.domain.Transformer
import io.reactivex.Completable
import io.reactivex.CompletableSource

class TestTransformer : Transformer() {

    override fun apply(upstream: Completable): CompletableSource {
        return upstream
    }
}