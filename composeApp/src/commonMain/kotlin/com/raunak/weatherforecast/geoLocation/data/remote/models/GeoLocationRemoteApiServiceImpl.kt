package com.raunak.weatherforecast.geoLocation.data.remote.models

import com.raunak.weatherforecast.common.data.safeRequest
import com.raunak.weatherforecast.geoLocation.data.remote.GeoLocationRemoteApiService
import com.raunak.weatherforecast.utils.ApiErrorResponse
import com.raunak.weatherforecast.utils.K
import com.raunak.weatherforecast.utils.Response
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow

class GeoLocationRemoteApiServiceImpl(
    private val httpClient: HttpClient
) : GeoLocationRemoteApiService {
    override fun searchLocation(query: String): Flow<Response<GeoLocationDto, ApiErrorResponse>> {
        return httpClient.safeRequest<GeoLocationDto, ApiErrorResponse> {
            url(urlString = K.GEO_CODING_BASE_URL + "/${K.GEO_CODING_END_POINT}")
            parameter("name", query)
        }
    }
}