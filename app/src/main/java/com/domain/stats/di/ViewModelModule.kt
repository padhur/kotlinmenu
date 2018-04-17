package com.domain.stats.di

import com.domain.stats.app.StatsApp
import com.domain.stats.webservice.ClientAPI
import com.domain.stats.viewmodel.StatsViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by padhu.r on 3/31/2018.
 */
@Module
class ViewModelModule {
    @Provides
    fun providePropertyListViewModelFactory(app : StatsApp, apiClient: ClientAPI) = StatsViewModelFactory(app, apiClient)
}