package com.domain.stats.di

import android.arch.lifecycle.ViewModelProviders
import com.domain.stats.view.StatsActivity
import com.domain.stats.view.StatsFragment
import com.domain.stats.viewmodel.StatsViewModel
import com.domain.stats.viewmodel.StatsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by padhu.r on 3/31/2018.
 */

@Module
abstract class StatsActivityChildFragmentsModule {
    @ContributesAndroidInjector
    abstract fun bindStatsListFragment(): StatsFragment
}

@Module
class StatsActivityModule {
    @Provides
    fun StatsActivityModule(activity: StatsActivity, statsViewModelFactory: StatsViewModelFactory) =
            ViewModelProviders.of(activity, statsViewModelFactory).get(StatsViewModel::class.java)
}