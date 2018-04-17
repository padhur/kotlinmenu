package com.domain.stats.di

import com.domain.stats.view.StatsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by padhu.r on 3/31/2018.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [StatsActivityModule::class, StatsActivityChildFragmentsModule::class, ViewModelModule::class])
    abstract fun bindStatsListActivity() : StatsActivity
}