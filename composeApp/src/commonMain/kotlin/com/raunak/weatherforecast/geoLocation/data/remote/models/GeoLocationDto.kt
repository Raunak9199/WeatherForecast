package com.raunak.weatherforecast.geoLocation.data.remote.models


import com.raunak.weatherforecast.geoLocation.domain.models.GeoLocation
import com.raunak.weatherforecast.utils.K
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeoLocationDto(
    @SerialName("generationtime_ms")
    val generationtimeMs: Double = 0.0,
    @SerialName("results")
    val results: List<Result> = listOf()
)

fun GeoLocationDto.toDomain(): List<GeoLocation> {
    return results.map {
        GeoLocation(
            id = it.id,
            name = it.name,
            countryId = it.countryId,
            countryCode = it.countryCode,
            countryName = it.country,
            flagUrl = K.flagUrl(it.countryCode),
            latitude = it.latitude,
            longitude = it.longitude,
            timezone = it.timezone,
            elevation = it.elevation.toDouble(),
        )
    }
}