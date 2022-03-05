package com.moonlightbutterfly.cryptobets.ui.composables

import android.widget.Toast
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moonlightbutterfly.cryptobets.SubscribeViewModel
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.ui.MainViewModel

@Composable
fun SubscribeToBet(
    betTitle: String,
    onApproved: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val viewModel = viewModel<SubscribeViewModel>(factory = LocalViewModelFactory.current)
        val bet by viewModel.getBet(betTitle).observeAsState(Bet("", emptyList(), 0.0, false))

        var amount by rememberSaveable { mutableStateOf(bet.minimumEntrance) }
        val (selectedOption, onOptionSelected) = remember {
            mutableStateOf("")
        }
        val context = LocalContext.current
        Text(
            modifier = Modifier.padding(top = 40.dp, bottom = 5.dp),
            text = bet.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(bottom = 20.dp),
            text = "Minimum entrance: ${bet.minimumEntrance} ETH"
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
                    ) { append("  $it  ") }
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
            value = "$amount ETH",
            onValueChange = {
                val number = it.removeSuffix(" ETH").toDoubleOrNull()
                amount = number ?: amount
            },
            label = { Text("Amount") },
            modifier = Modifier.padding(bottom = 30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                when {
                    amount < bet.minimumEntrance -> {
                        Toast.makeText(context, "Your bet is too low", Toast.LENGTH_SHORT).show()
                    }
                    selectedOption.isEmpty() -> {
                        Toast.makeText(context, "Select an option", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        viewModel.bet(bet, amount, selectedOption) {
                            Toast.makeText(context,"Your bet should soon be visible", Toast.LENGTH_LONG).show()
                            onApproved()
                        }
                    }
                }
            }
        ) {
            Text(text = "OK")
        }
    }
}