package com.farahani.elmira.cleanapp.di.modules

import com.farahani.elmira.data.api.ApiService
import com.farahani.elmira.data.api.ApiUtils
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Module
    companion object {

        @Provides
        @Reusable
        @JvmStatic
        internal fun provideRetrofitApiService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        @Reusable
        @JvmStatic
        internal fun provideRetrofitInterface(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(ApiUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
        }

        @Provides
        @Singleton
        internal fun provideApiService(apiService: ApiService): ApiService {
            return apiService
        }
    }
}