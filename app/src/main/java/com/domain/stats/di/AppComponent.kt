package com.domain.stats.di

import com.domain.stats.app.StatsApp
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by padhu.r on 3/31/2018.
 */
@Singleton
@Component(modules = [(AppModule::class),
    (NetworkModule::class),
    (ActivityModule::class)])
interface AppComponent : AndroidInjector<StatsApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<StatsApp>()
}