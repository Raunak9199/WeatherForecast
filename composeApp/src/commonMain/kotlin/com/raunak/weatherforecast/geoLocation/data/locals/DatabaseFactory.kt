package com.raunak.weatherforecast.geoLocation.data.locals

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<GeolocationDatabase>
}