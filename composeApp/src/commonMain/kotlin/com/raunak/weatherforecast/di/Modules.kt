package com.raunak.weatherforecast.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.raunak.weatherforecast.common.data.HttpClientFactory
import com.raunak.weatherforecast.common.data.Mapper
import com.raunak.weatherforecast.forecast.data.mapper.ApiDailyWeatherMapper
import com.raunak.weatherforecast.forecast.data.mapper.ApiHourlyMapper
import com.raunak.weatherforecast.forecast.data.mapper.ApiMapper
import com.raunak.weatherforecast.forecast.data.mapper.ApiWeatherMapper
import com.raunak.weatherforecast.forecast.data.mapper.CurrentWeatherMapper
import com.raunak.weatherforecast.forecast.data.remote.ForecastRemoteApiService
import com.raunak.weatherforecast.forecast.data.remote.ForecastRemoteApiServiceImpl
import com.raunak.weatherforecast.forecast.data.remote.models.CurrentDto
import com.raunak.weatherforecast.forecast.data.remote.models.DailyDto
import com.raunak.weatherforecast.forecast.data.remote.models.HourlyDto
import com.raunak.weatherforecast.forecast.data.remote.models.WeatherDto
import com.raunak.weatherforecast.forecast.data.repository.ForecastRepoImpl
import com.raunak.weatherforecast.forecast.domain.models.CurrentWeather
import com.raunak.weatherforecast.forecast.domain.models.Daily
import com.raunak.weatherforecast.forecast.domain.models.Hourly
import com.raunak.weatherforecast.forecast.domain.models.Weather
import com.raunak.weatherforecast.forecast.domain.repo.ForecastRepository
import com.raunak.weatherforecast.geoLocation.data.locals.DatabaseFactory
import com.raunak.weatherforecast.geoLocation.data.locals.GeolocationDatabase
import com.raunak.weatherforecast.geoLocation.data.locals.models.GeoLocationEntity
import com.raunak.weatherforecast.geoLocation.data.mapper.GeoLocationMapper
import com.raunak.weatherforecast.geoLocation.data.remote.GeoLocationRemoteApiService
import com.raunak.weatherforecast.geoLocation.data.remote.models.GeoLocationRemoteApiServiceImpl
import com.raunak.weatherforecast.geoLocation.data.repository.GeoLocationRepositoryImpl
import com.raunak.weatherforecast.geoLocation.domain.models.GeoLocation
import com.raunak.weatherforecast.geoLocation.domain.repo.GeoLocationRepoInterface
import com.raunak.weatherforecast.ui.forecast.ForecastViewModal
import com.raunak.weatherforecast.ui.home.HomeViewModel
import com.raunak.weatherforecast.utils.provideExternalCoroutineScope
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single {
        get<DatabaseFactory>()
            .create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<GeolocationDatabase>().geolocationDao() }
    single { HttpClientFactory.create(get()) }
    single { provideExternalCoroutineScope() }.bind()
    singleOf(::GeoLocationRemoteApiServiceImpl).bind<GeoLocationRemoteApiService>()
    singleOf(::GeoLocationRepositoryImpl).bind<GeoLocationRepoInterface>()
    singleOf(::GeoLocationMapper).bind<Mapper<GeoLocation, GeoLocationEntity>>()

    singleOf(::ForecastRemoteApiServiceImpl).bind<ForecastRemoteApiService>()
    singleOf(::ApiDailyWeatherMapper).bind<ApiMapper<Daily, DailyDto>>()
    singleOf(::ApiHourlyMapper).bind<ApiMapper<Hourly, HourlyDto>>()
    singleOf(::ApiWeatherMapper).bind<ApiMapper<Weather, WeatherDto>>()
    singleOf(::CurrentWeatherMapper).bind<ApiMapper<CurrentWeather, CurrentDto>>()
    singleOf(::ForecastRepoImpl).bind<ForecastRepository>()


    viewModelOf(::HomeViewModel)
    viewModelOf(::ForecastViewModal)
}