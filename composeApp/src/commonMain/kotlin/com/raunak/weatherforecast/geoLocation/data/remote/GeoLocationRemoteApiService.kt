package com.raunak.weatherforecast.geoLocation.data.remote

import com.raunak.weatherforecast.geoLocation.data.remote.models.GeoLocationDto
import com.raunak.weatherforecast.utils.ApiErrorResponse
import com.raunak.weatherforecast.utils.Response
import kotlinx.coroutines.flow.Flow

interface GeoLocationRemoteApiService {
    fun searchLocation(query: String): Flow<Response<GeoLocationDto, ApiErrorResponse>>
}