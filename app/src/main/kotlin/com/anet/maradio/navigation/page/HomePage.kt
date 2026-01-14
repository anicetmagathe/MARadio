package com.anet.maradio.navigation.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.compose.material3.buttons.NextButton
import androidx.media3.ui.compose.material3.buttons.PlayPauseButton
import androidx.media3.ui.compose.material3.buttons.PreviousButton
import core.designsystem.theme.AppTheme
import core.ui.DevicePreviews

@Composable
fun HomePage(modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    HomePageImpl(modifier = modifier, state = state, onChooseRadio = viewModel::play)
}

@Composable
fun HomePageImpl(modifier: Modifier = Modifier, state: HomeState, onChooseRadio: (Int) -> Unit) {
    Surface(modifier = modifier, color = Color.White, contentColor = Color.Black) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            LazyColumn() {
                itemsIndexed(state.radios) { index, radio ->
                    Card(onClick = { onChooseRadio(index) }) {
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                if (index == state.selectedRadio) {
                                    Box(
                                        modifier = Modifier
                                            .size(10.dp)
                                            .background(color = Color.Red, shape = CircleShape)
                                    )
                                }

                                Text(text = radio.name)
                            }
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PreviousButton(player = state.player)

                PlayPauseButton(player = state.player)

                NextButton(player = state.player)
            }
        }

    }

}

@DevicePreviews
@Composable
private fun HomePagePreview() {
    AppTheme {
        HomePageImpl(
            state = HomeState(
                player = ExoPlayer.Builder(LocalContext.current).build(),
                radios = emptyList()
            ), onChooseRadio = {})
    }
}