package com.raunak.weatherforecast

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.window.ComposeUIViewController
import com.raunak.weatherforecast.di.initKoin

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    val calculatedScreenSize = calculateWindowSizeClass()
    App(calculatedScreenSize.widthSizeClass)
}