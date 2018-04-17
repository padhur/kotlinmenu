package com.domain.menulog.di

import android.arch.lifecycle.ViewModelProviders
import com.domain.menulog.view.RestaurantActivity
import com.domain.menulog.view.ResultFragment
import com.domain.menulog.viewmodel.StatsViewModel
import com.domain.menulog.viewmodel.StatsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by padhu.r on 3/31/2018.
 */

@Module
abstract class StatsActivityChildFragmentsModule {
    @ContributesAndroidInjector
    abstract fun bindStatsListFragment(): ResultFragment
}

@Module
class StatsActivityModule {
    @Provides
    fun StatsActivityModule(activity: RestaurantActivity, statsViewModelFactory: StatsViewModelFactory) =
            ViewModelProviders.of(activity, statsViewModelFactory).get(StatsViewModel::class.java)
}