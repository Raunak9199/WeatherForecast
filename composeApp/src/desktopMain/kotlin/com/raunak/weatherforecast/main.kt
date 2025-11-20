package com.raunak.weatherforecast

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
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

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
fun main(){
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "WeatherForecast",
        ) {
            val calculatedScreenSize = calculateWindowSizeClass()
            App(calculatedScreenSize.widthSizeClass)
        }
    }
}