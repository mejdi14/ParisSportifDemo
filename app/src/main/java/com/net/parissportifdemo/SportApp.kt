package com.net.parissportifdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SportApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
