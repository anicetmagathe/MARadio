package com.anet.maradio.navigation.page

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class Radio(val name: String, val streamingUrl: String)

data class HomeState(val player: Player, val radios: List<Radio>, val selectedRadio: Int? = null)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val player: Player
) : ViewModel() {
    private val _state = MutableStateFlow(
        HomeState(
            player = player,
            radios = listOf(
                Radio("Tsiry", "http://109.123.251.210:8000/radio_tsiry"),
                Radio("Mampita", "http://146.59.157.199:8000/3"),
                Radio("Soafia", "http://102.16.44.51:8000/radiosoafia"),
                Radio("RDJ", "http://rdj966.net:8000/rdj966.mp3"),
                Radio("Paradisagasy", "https://stream.deevaradio.net:10443/paradisagasy"),
                Radio("ROFIA", "http://146.59.157.199:8000/2"),
            ),
        )
    )
    val state = _state.asStateFlow()

    init {
        player.addListener(
            object : Player.Listener {
                override fun onPlaybackStateChanged(playbackState: Int) {
                    val message = when (playbackState) {
                        Player.STATE_IDLE -> "STATE_IDLE"
                        Player.STATE_BUFFERING -> "STATE_BUFFERING"
                        Player.STATE_READY -> "STATE_READY"
                        Player.STATE_ENDED -> "STATE_ENDED"
                        else -> throw RuntimeException("Invalid state")
                    }
                    Log.d("MARadioLog", message)
                }
            }
        )
    }

    fun play(index: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(selectedRadio = index)
            }

            val mediaItem = MediaItem.fromUri(
                _state.value.radios[index].streamingUrl
            )

            player.setMediaItem(mediaItem)
            player.prepare()
            player.play()
        }
    }
}