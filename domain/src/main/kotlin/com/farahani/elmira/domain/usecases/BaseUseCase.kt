package com.farahani.elmira.domain.usecases

import io.reactivex.Completable

interface BaseUseCase{
    fun execute():Completable
}