package com.saavatech.financialapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TransferMeApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}