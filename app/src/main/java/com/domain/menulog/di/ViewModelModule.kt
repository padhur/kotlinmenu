package com.domain.menulog.di

import com.domain.menulog.app.Restaurants
import com.domain.menulog.webservice.ClientAPI
import com.domain.menulog.viewmodel.StatsViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by padhu.r on 3/31/2018.
 */
@Module
class ViewModelModule {
    @Provides
    fun providePropertyListViewModelFactory(app : Restaurants, apiClient: ClientAPI) = StatsViewModelFactory(app, apiClient)
}