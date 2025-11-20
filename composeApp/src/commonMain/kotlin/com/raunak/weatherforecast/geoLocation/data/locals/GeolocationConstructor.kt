package com.raunak.weatherforecast.geoLocation.data.locals

import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object GeolocationConstructor: RoomDatabaseConstructor<GeolocationDatabase> {
    override fun initialize(): GeolocationDatabase

}

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<GeolocationDatabase>
}