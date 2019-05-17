package com.farahani.elmira.domain.usecases.common

import io.reactivex.Completable

interface BaseUseCase{
    fun execute():Completable
}