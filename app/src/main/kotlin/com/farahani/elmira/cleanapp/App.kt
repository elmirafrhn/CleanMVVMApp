package com.farahani.elmira.cleanapp

import android.util.Log
import com.farahani.elmira.cleanapp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        createDBLogger()
    }

    private fun createDBLogger() {
        if (BuildConfig.DEBUG) {
            val debugDB = Class.forName("com.amitshekhar.DebugDB")
            val getAddressLog = debugDB.getMethod("getAddressLog")
            val value = getAddressLog.invoke(null)
            Log.i("elmira", value.toString())
        }
    }
}