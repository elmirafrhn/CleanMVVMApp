package com.farahani.elmira.cleanapp.di.modules

import com.farahani.elmira.data.api.ApiService
import com.farahani.elmira.data.api.ApiServiceImpl
import com.farahani.elmira.data.api.ApiUtils
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
        fun provideRetrofitApiService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        @Reusable
        @JvmStatic
        fun provideRetrofitInterface(): Retrofit {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            return Retrofit.Builder()
                .baseUrl(ApiUtils.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
        }

        @Provides
        @Singleton
        fun provideApiService(apiService: ApiServiceImpl): ApiService {
            return apiService
        }
    }
}