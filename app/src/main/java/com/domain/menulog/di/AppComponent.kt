package com.domain.menulog.di

import com.domain.menulog.app.Restaurants
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
interface AppComponent : AndroidInjector<Restaurants> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<Restaurants>()
}