package com.domain.menulog.app

import android.app.Activity
import android.app.Application
import com.domain.menulog.di.DaggerAppComponent
import com.domain.menulog.BuildConfig
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

/**
 * Created by padhu.r on 3/31/2018.
 */
class Restaurants : Application(), HasActivityInjector {
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