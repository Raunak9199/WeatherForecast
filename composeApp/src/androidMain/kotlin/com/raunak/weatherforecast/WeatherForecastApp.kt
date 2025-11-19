package com.raunak.weatherforecast

import android.app.Application
import com.raunak.weatherforecast.di.initKoin
import org.koin.android.ext.koin.androidContext


class WeatherForecastApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@WeatherForecastApp)
        }
    }
}