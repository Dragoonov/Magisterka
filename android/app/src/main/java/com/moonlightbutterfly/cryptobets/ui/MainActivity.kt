package com.moonlightbutterfly.cryptobets.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moonlightbutterfly.cryptobets.repository.BlockchainFacade
import com.moonlightbutterfly.cryptobets.ui.composables.Bets
import com.moonlightbutterfly.cryptobets.ui.composables.LocalViewModelFactory
import com.moonlightbutterfly.cryptobets.ui.composables.Login
import com.moonlightbutterfly.cryptobets.ui.composables.SubscribeToBet
import com.moonlightbutterfly.cryptobets.ui.theme.CryptoBetsTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    private var timeOfLastClick: Long = 0

    private val mainViewModelProvider = ViewModelProvider(
        BlockchainFacade()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalViewModelFactory provides mainViewModelProvider) {
                CryptoBetsTheme {
                    navController = rememberNavController()
                    Scaffold { padding ->
                        NavHost(
                            navController,
                            startDestination = Routes.LOGIN,
                            Modifier.padding(padding)) {
                            composable(Routes.LOGIN) {
                                Login {
                                    navController.navigate(Routes.BETS)
                                }
                            }
                            composable(Routes.BETS) {
                                Bets {
                                    navController.navigate("${Routes.SUBSCRIBE_TO_BET}/$it")
                                }
                            }
                            composable("${Routes.SUBSCRIBE_TO_BET}/{title}") {
                                SubscribeToBet(it.arguments?.getString("title")!! + "?") {
                                    navController.popBackStack()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if (navController.currentDestination!!.route!!.contains(Routes.SUBSCRIBE_TO_BET)) {
            super.onBackPressed()
        } else {
            val time = System.currentTimeMillis()
            if (time - timeOfLastClick < 1000 && timeOfLastClick != 0L) {
                finish()
            } else {
                Toast.makeText(applicationContext, "Press again to exit", Toast.LENGTH_SHORT).show()
                timeOfLastClick = time
            }
        }
    }
}