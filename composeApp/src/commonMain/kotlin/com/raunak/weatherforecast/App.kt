package com.raunak.weatherforecast

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.raunak.weatherforecast.ui.components.NavigationType
import com.raunak.weatherforecast.ui.components.getNavigationType
import com.raunak.weatherforecast.ui.home.HomeScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import weatherforecast.composeapp.generated.resources.Res
import weatherforecast.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App(windowWidthSizeClass: WindowWidthSizeClass) {
    MaterialTheme {
        HomeScreen(
            navigationType = getNavigationType(windowWidthSizeClass)
        )
    }
}