package com.farahani.elmira.cleanapp.di.component

import com.farahani.elmira.cleanapp.App
import com.farahani.elmira.cleanapp.di.modules.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        DbModule::class,
        PostsViewModelModule::class,
        UsecasesModule::class,
        ActivitiesBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}