package com.raunak.weatherforecast

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.raunak.weatherforecast.di.initKoin

//fun main() = application {
//    Window(
//        onCloseRequest = ::exitApplication,
//        title = "WeatherForecast",
//    ) {
//        App()
//    }
//}

fun main(){
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "WeatherForecast",
        ) {
            App()
        }
    }
}