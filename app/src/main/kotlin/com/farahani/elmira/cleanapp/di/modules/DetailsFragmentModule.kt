package com.farahani.elmira.cleanapp.di.modules

import com.farahani.elmira.presentation.details.DetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailsFragmentModule {

    @ContributesAndroidInjector
    abstract fun detailsFragment(): DetailsFragment
}