package com.moonlightbutterfly.cryptobets.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.Option
import com.moonlightbutterfly.cryptobets.ui.MainViewModel

@Composable
fun SubscribeToBet(
    smartContractAddress: String,
    onApproved: (bet: Bet, amount: Double, option: Option) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val viewModel = viewModel<MainViewModel>(factory = LocalViewModelFactory.current)
        val bet = viewModel.getBet(smartContractAddress)
        var amount by rememberSaveable { mutableStateOf(.0) }
        val (selectedOption, onOptionSelected) = remember {
            mutableStateOf(bet.options[0])
        }
        Text(
            modifier = Modifier.padding(top = 40.dp, bottom = 5.dp),
            text = bet.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = bet.identifier,
        )
        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
            text = "Choose option"
        )
        bet.options.forEach {
            Row(
                Modifier.padding(bottom = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (it == selectedOption),
                    onClick = { onOptionSelected(it) }
                )
                val annotatedString = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.Bold)
                    ){ append("  ${it.name}  ") }
                }
                ClickableText(
                    text = annotatedString,
                    onClick = {
                        onOptionSelected(bet.options[it])
                    }
                )
            }
        }
        OutlinedTextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = amount.toString(),
            onValueChange = {amount = it.toDouble()},
            label = { Text("Amount") },
            modifier = Modifier.padding(bottom = 30.dp)
        )

        Button(
            onClick = { onApproved(bet, amount, selectedOption) }
        ) {
            Text(text = "OK")
        }
    }
}