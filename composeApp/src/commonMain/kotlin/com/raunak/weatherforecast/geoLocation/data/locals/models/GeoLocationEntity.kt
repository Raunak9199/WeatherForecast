package com.raunak.weatherforecast.geoLocation.data.locals.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("geolocation_table")
data class GeoLocationEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int =1,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val countryName: String,
    val countryCode: String,
    val countryId: Int,
    val timezone: String,
    val elevation: Double
)
