package com.raunak.weatherforecast.geoLocation.data.repository

import com.raunak.weatherforecast.common.data.Mapper
import com.raunak.weatherforecast.geoLocation.data.locals.GeolocationDao
import com.raunak.weatherforecast.geoLocation.data.locals.models.GeoLocationEntity
import com.raunak.weatherforecast.geoLocation.data.remote.GeoLocationRemoteApiService
import com.raunak.weatherforecast.geoLocation.data.remote.models.toDomain
import com.raunak.weatherforecast.geoLocation.domain.models.GeoLocation
import com.raunak.weatherforecast.geoLocation.domain.repo.GeoLocationRepoInterface
import com.raunak.weatherforecast.utils.ApiErrorResponse
import com.raunak.weatherforecast.utils.Response
import com.raunak.weatherforecast.utils.map
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn

class GeoLocationRepositoryImpl(
    private val geoLocationRemoteApiService: GeoLocationRemoteApiService,
    private val geoLocationDao: GeolocationDao,
    private val geoLocationMapper: Mapper<GeoLocation, GeoLocationEntity>,
    private val externalScope: CoroutineScope,
) : GeoLocationRepoInterface {
    override val geoLocation: Flow<GeoLocation?>
        get() {
            return geoLocationDao.getGeoLocation().map { data ->
                geoLocationMapper.mapToDomainOrNull(data)
            }.shareIn(scope = externalScope, started = SharingStarted.Lazily)
        }

    override suspend fun upsertLocation(geoLocation: GeoLocation) {
        geoLocationDao.upsertGeoLocation(geoLocationMapper.mapFromDomain(geoLocation))
    }

    override fun fetchGeoLocation(query: String): Flow<Response<List<GeoLocation>, ApiErrorResponse>> {
        return geoLocationRemoteApiService.searchLocation(query = query).map { response ->
            response.map { geoLocDto ->
                geoLocDto.toDomain()
            }
        }
    }

    override suspend fun deleteLocation() {
        geoLocationDao.deleteGeoLocation()
    }

    override suspend fun clear() {
        externalScope.cancel()
    }
}