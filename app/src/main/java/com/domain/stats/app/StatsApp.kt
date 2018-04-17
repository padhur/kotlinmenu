package com.domain.stats.app

import android.app.Activity
import android.app.Application
import com.domain.stats.di.DaggerAppComponent
import com.domain.stats.BuildConfig
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

/**
 * Created by padhu.r on 3/31/2018.
 */
class StatsApp : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
        DaggerAppComponent
                .builder()
                .create(this)
                .inject(this)
    }
}