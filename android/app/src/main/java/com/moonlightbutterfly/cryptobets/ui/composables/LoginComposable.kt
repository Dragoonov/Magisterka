package com.moonlightbutterfly.cryptobets.ui.composables

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Login(onOkClicked: (publicKey: String, privateKey: String) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var publicKey by rememberSaveable { mutableStateOf("") }
        
        Text(
            text = "CryptoBets",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            color = MaterialTheme.colors.primary
        )
        
        OutlinedTextField(
            value = publicKey,
            onValueChange = {
                publicKey = it
            },
            label = { Text("Public key") },
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
            onClick = { onOkClicked(publicKey, privateKey) }
        ) {
            Text(text = "OK")
        }
    }
}