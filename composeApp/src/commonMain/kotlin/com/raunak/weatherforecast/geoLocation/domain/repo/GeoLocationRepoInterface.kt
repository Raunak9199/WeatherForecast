package com.raunak.weatherforecast.geoLocation.domain.repo

import com.raunak.weatherforecast.geoLocation.domain.models.GeoLocation
import com.raunak.weatherforecast.utils.ApiErrorResponse
import com.raunak.weatherforecast.utils.Response
import kotlinx.coroutines.flow.Flow

interface GeoLocationRepoInterface {
    val geoLocation: Flow<GeoLocation?>
    suspend fun upsertLocation(geoLocation: GeoLocation)
    fun fetchGeoLocation(query: String): Flow<Response<List<GeoLocation>, ApiErrorResponse>>
    suspend fun deleteLocation()
    suspend fun clear()
}