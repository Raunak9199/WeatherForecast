package com.raunak.weatherforecast.common.data

interface Mapper<Domain,Model> {
    fun mapToDomainOrNull(model:Model?):Domain?
    fun mapFromDomain(domain:Domain):Model
}