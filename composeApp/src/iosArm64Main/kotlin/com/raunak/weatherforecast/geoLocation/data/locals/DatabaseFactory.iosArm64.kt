package com.raunak.weatherforecast.geoLocation.data.locals

import androidx.room.RoomDatabase
import com.raunak.weatherforecast.geoLocation.data.locals.GeolocationDatabase

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<GeolocationDatabase> {
        TODO("Not yet implemented")
    }
}