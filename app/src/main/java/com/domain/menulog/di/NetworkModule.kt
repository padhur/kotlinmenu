package com.domain.menulog.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.domain.menulog.network.WebService
import com.domain.menulog.network.Config
import com.domain.menulog.BuildConfig
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient



/**
 * Created by padhu.r on 3/31/2018.
 */
@Module
class NetworkModule {
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }

    @Provides
    fun providesRetrofit(gson: Gson): Retrofit {
        if(BuildConfig.DEBUG) {
            val okHttpClient = OkHttpClient.Builder()
                    .addNetworkInterceptor(StethoInterceptor())
                    .addInterceptor(addheadersInterceptor())
                    .build()
            return Retrofit.Builder()
                    .baseUrl(Config.baseurl)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        } else {
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(addheadersInterceptor())
                    .build()
            return Retrofit.Builder()
                    .baseUrl(Config.baseUrl1)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        }
    }

    fun addheadersInterceptor() = Interceptor { chain ->
        chain.proceed(chain.request().newBuilder()
                .addHeader("Authorization",Config.authval)
                .addHeader("Accept-Tenant", Config.tenant)
                .addHeader("Accept-Language", Config.language)
                .build())
    }
}