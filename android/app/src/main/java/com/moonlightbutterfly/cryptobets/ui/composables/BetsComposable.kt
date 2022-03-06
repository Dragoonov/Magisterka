package com.moonlightbutterfly.cryptobets.ui.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moonlightbutterfly.cryptobets.models.Bet
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
    val isEmpty by viewModel.isEmpty.observeAsState(true)

    var currentRotation by remember { mutableStateOf(0f) }
    val rotation = remember { Animatable(currentRotation) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = viewModel::refresh) {
                Icon(imageVector = Icons.Rounded.Refresh, contentDescription = "Refresh")
            }
        }
    ) {

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
            if (isEmpty) {
                LaunchedEffect(key1 = isEmpty) {
                    rotation.animateTo(
                        targetValue = currentRotation + 360f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(3000, easing = LinearEasing),
                            repeatMode = RepeatMode.Restart
                        )
                    ) {
                        currentRotation = value
                    }
                }
                Row(Modifier.fillMaxWidth().fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Icon(
                        imageVector = Icons.Rounded.Refresh,
                        contentDescription = "Refresh",
                        Modifier
                            .size(50.dp)
                            .rotate(currentRotation)
                    )
                }
            } else {
                LazyColumn {
                    when (selectedOption) {
                        0 -> {
                            items(allBets ?: emptyList()) {
                                Bet(
                                    bet = it.bet,
                                    onBetClicked = onBetClicked,
                                    showBet = true,
                                )
                            }
                        }
                        1 -> {
                            items(userBets ?: emptyList()) {
                                Bet(
                                    bet = it.bet,
                                    onBetClicked = onBetClicked,
                                    howMuchPaid = it.contribution,
                                    pickedOption = it.pickedOption
                                )
                            }
                        }
                        2 -> {
                            items(endedBets ?: emptyList()) {
                                Bet(
                                    bet = it.bet,
                                    onBetClicked = onBetClicked,
                                    howMuchPaid = it.contribution,
                                    howMuchWon = it.reward,
                                    pickedOption = it.pickedOption,
                                    winOption = it.winOption
                                )
                            }
                        }
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
    pickedOption: String? = null,
    winOption: String? = null
) {
    Card(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable(showBet) { onBetClicked(bet.title) }
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
                Text(text = it, modifier = Modifier.padding(start = 25.dp))
            }
            Spacer(modifier = Modifier.padding(20.dp))
            if (pickedOption != null) {
                Text(
                    text = "Picked option: $pickedOption",
                    modifier = Modifier.padding(start = 25.dp)
                )
                if (bet.isResolved) {
                    Text(
                        text = "Winning option: $winOption",
                        modifier = Modifier.padding(start = 25.dp, bottom = 10.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (howMuchPaid != null) {
                    Text(
                        text = "Paid: $howMuchPaid ETH",
                    )
                }
                if (howMuchWon != null) {
                    Text(
                        text = if (howMuchWon > 0) "Won $howMuchWon ETH" else "Lost",
                        color = if (howMuchWon > 0) Color.Green else Color.Red,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
                if (showBet) {
                    Button(
                        onClick = { onBetClicked(bet.title) },
                        modifier = Modifier
                            .padding(end = 10.dp)
                    ) {
                        Text("Bet")
                    }
                }
            }
        }
    }
}