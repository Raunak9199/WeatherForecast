package com.raunak.weatherforecast.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.raunak.weatherforecast.geoLocation.data.locals.DatabaseFactory
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single{
        get<DatabaseFactory>()
            .create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}