package com.moonlightbutterfly.cryptobets.ui.composables

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moonlightbutterfly.cryptobets.LoginViewModel

@Composable
fun Login(onOkClicked: () -> Unit) {
    val loginViewModel = viewModel<LoginViewModel>(factory = LocalViewModelFactory.current)
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "CryptoBets",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            color = MaterialTheme.colors.primary
        )
        var privateKey by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            value = privateKey,
            onValueChange = {
                privateKey = it
            },
            label = { Text("Private key") },
        )
        Button(
            onClick = {
                val approved = loginViewModel.onCredentialsApproved(privateKey)
                if (approved) {
                    onOkClicked()
                } else {
                    Toast.makeText(context, "Given key is invalid!", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "OK")
        }
    }
}