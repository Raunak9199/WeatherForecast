package com.raunak.weatherforecast.geoLocation.domain.models

import com.raunak.weatherforecast.utils.FlagUrl

data class GeoLocation(
    val id: Int = 0,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val countryName: String,
    val countryCode: String,
    val countryId: Int,
    val timezone: String,
    val elevation: Double,
    val flagUrl: FlagUrl,
)
