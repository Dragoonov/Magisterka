package com.moonlightbutterfly.cryptobets.ui.composables

import androidx.compose.runtime.compositionLocalOf
import com.moonlightbutterfly.cryptobets.ui.MainViewModelProvider

val LocalViewModelFactory = compositionLocalOf<MainViewModelProvider> { error("No view model factory found!") }