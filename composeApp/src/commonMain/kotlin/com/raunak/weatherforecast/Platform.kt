package com.raunak.weatherforecast

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform