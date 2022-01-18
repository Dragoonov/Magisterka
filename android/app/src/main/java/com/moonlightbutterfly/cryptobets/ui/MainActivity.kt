package com.moonlightbutterfly.cryptobets.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import com.moonlightbutterfly.cryptobets.repository.BlockchainBetsRepository
import com.moonlightbutterfly.cryptobets.ui.composables.Bets
import com.moonlightbutterfly.cryptobets.ui.composables.LocalViewModelFactory
import com.moonlightbutterfly.cryptobets.ui.composables.Login
import com.moonlightbutterfly.cryptobets.ui.composables.SubscribeToBet
import com.moonlightbutterfly.cryptobets.ui.theme.CryptoBetsTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    private var timeOfLastClick: Long = 0

    private val db = Firebase.firestore

    private val mainViewModelProvider = MainViewModelProvider(BlockchainBetsRepository(db))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalViewModelFactory provides mainViewModelProvider) {
                val viewModel = viewModel<MainViewModel>(factory = LocalViewModelFactory.current)
                CryptoBetsTheme {
                    navController = rememberNavController()
                    Scaffold { padding ->
                        NavHost(
                            navController,
                            startDestination = Routes.LOGIN,
                            Modifier.padding(padding)) {
                            composable(Routes.LOGIN) {
                                Login { publicKey, privateKey ->
                                    viewModel.onCredentialsApproved(publicKey, privateKey)
                                    navController.navigate(Routes.BETS)
                                }
                            }
                            composable(Routes.BETS) {
                                Bets {
                                    navController.navigate("${Routes.SUBSCRIBE_TO_BET}/$it")
                                }
                            }
                            composable("${Routes.SUBSCRIBE_TO_BET}/{address}") {
                                SubscribeToBet(it.arguments?.getString("address")!!) { bet, amount, option ->
                                    viewModel.bet(bet, amount, option)
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