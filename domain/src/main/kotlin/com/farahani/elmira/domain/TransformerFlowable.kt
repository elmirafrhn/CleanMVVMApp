package com.farahani.elmira.domain

import io.reactivex.FlowableTransformer

abstract class TransformerFlowable<T> : FlowableTransformer<T, T>