package com.nora.rickscrate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class RicksCrateApplication : Application() {

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }
}