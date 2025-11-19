package com.raunak.weatherforecast.geoLocation.data.mapper

import com.raunak.weatherforecast.common.data.Mapper
import com.raunak.weatherforecast.geoLocation.data.locals.models.GeoLocationEntity
import com.raunak.weatherforecast.geoLocation.domain.models.GeoLocation
import com.raunak.weatherforecast.utils.K

class GeoLocationMapper : Mapper<GeoLocation, GeoLocationEntity> {
    override fun mapToDomainOrNull(model: GeoLocationEntity?): GeoLocation? {
        return model?.run {
            GeoLocation(
                id,
                name,
                latitude,
                longitude,
                countryName,
                countryCode,
                countryId,
                timezone,
                elevation,
                flagUrl = K.flagUrl(countryCode)
            )
        }
    }

    override fun mapFromDomain(domain: GeoLocation): GeoLocationEntity {
        return domain.run {
            GeoLocationEntity(
                id,
                name,
                latitude,
                longitude,
                countryName,
                countryCode,
                countryId,
                timezone,
                elevation,
            )
        }
    }
}