package com.moonlightbutterfly.cryptobets.ui.composables

import androidx.compose.runtime.compositionLocalOf
import com.moonlightbutterfly.cryptobets.ui.ViewModelProvider

val LocalViewModelFactory = compositionLocalOf<ViewModelProvider> { error("No view model factory found!") }