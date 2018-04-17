package com.domain.menulog.di

import com.domain.menulog.webservice.ClientAPI
import com.domain.menulog.network.WebService
import dagger.Module
import dagger.Provides


/**
 * Created by padhu.r on 3/31/2018.
 */
@Module
class AppModule {
    @Provides
    fun provideApiClient(apiService: WebService): ClientAPI {
        return ClientAPI(apiService)
    }
}