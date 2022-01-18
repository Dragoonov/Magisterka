package com.moonlightbutterfly.cryptobets.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moonlightbutterfly.cryptobets.models.Bet
import com.moonlightbutterfly.cryptobets.models.Option
import com.moonlightbutterfly.cryptobets.ui.MainViewModel

@Composable
fun Bets(onBetClicked: (String) -> Unit) {
    val viewModel = viewModel<MainViewModel>(factory = LocalViewModelFactory.current)

    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(0)
    }
    val allBets by viewModel.allBets.observeAsState()
    val userBets by viewModel.enteredBets.observeAsState()
    val endedBets by viewModel.resolvedBets.observeAsState()

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(
            Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            Arrangement.SpaceEvenly
        ) {
            Chip(
                name = "All bets",
                isSelected = selectedOption == 0,
                onSelectionChanged = {
                    onOptionSelected(0)
                }
            )
            Chip(
                name = "My bets",
                isSelected = selectedOption == 1,
                onSelectionChanged = {
                    onOptionSelected(1)
                }
            )
            Chip(
                name = "Ended bets",
                isSelected = selectedOption == 2,
                onSelectionChanged = {
                    onOptionSelected(2)
                }
            )
        }

        LazyColumn {
            when (selectedOption) {
                0 -> {
                    items(allBets!!) {
                        Bet(
                            bet = it,
                            onBetClicked = onBetClicked,
                            showBet = true,
                        )
                    }
                }
                1 -> {
                    items(userBets!!) {
                        Bet(
                            bet = it.bet,
                            onBetClicked = onBetClicked,
                            howMuchPaid = it.contribution,
                            pickedOption = it.pickedOption
                        )
                    }
                }
                2 -> {
                    items(endedBets!!) {
                        Bet(
                            bet = it.bet,
                            onBetClicked = onBetClicked,
                            howMuchPaid = it.contribution,
                            howMuchWon = it.reward,
                            pickedOption = it.pickedOption
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Chip(
    name: String = "Chip",
    isSelected: Boolean = false,
    onSelectionChanged: () -> Unit = {},
) {
    Surface(
        modifier = Modifier
            .clip(CircleShape)
            .border(1.dp, MaterialTheme.colors.primary, CircleShape)
            .toggleable(
                value = isSelected,
                onValueChange = { onSelectionChanged() }
            ),
        color = if (isSelected) MaterialTheme.colors.primary else Color.Transparent
    ) {
        Text(
            text = name,
            color = if (isSelected) Color.White else MaterialTheme.colors.primary,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun Bet(
    bet: Bet,
    onBetClicked: (String) -> Unit,
    howMuchPaid: Double? = null,
    howMuchWon: Double? = null,
    showBet: Boolean = false,
    pickedOption: Option? = null
) {
    Card(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Text(
                text = bet.title,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            bet.options.forEach {
                Text(text = "${it.value}. ${it.name}", modifier = Modifier.padding(start = 25.dp))
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Smart contract: ${bet.identifier}",
                modifier = Modifier.padding(start = 25.dp)
            )
            Text(
                text = "Picked option: ${pickedOption?.value}",
                modifier = Modifier
                    .alpha((if (pickedOption != null) 1f else 0f))
                    .padding(start = 25.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Paid: $howMuchPaid ETH",
                    modifier = Modifier
                        .alpha(if (howMuchPaid != null) 1f else 0f)
                        .weight(1f)
                )
                Text(
                    text = if (howMuchWon != null) "Won $howMuchWon ETH" else "Lost",
                    color = if (howMuchWon != null && howMuchWon > 0) Color.Green else Color.Red,
                    modifier = Modifier
                        .alpha(if (howMuchWon != null) 1f else 0f)
                        .weight(1f)
                )
                Button(
                    onClick = { onBetClicked(bet.identifier) },
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .alpha(if (showBet) 1f else 0f)
                        .weight(1f)
                ) {
                    Text("Bet")
                }
            }
        }
    }
}