package com.raunak.weatherforecast

import androidx.compose.ui.window.ComposeUIViewController
import com.raunak.weatherforecast.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }