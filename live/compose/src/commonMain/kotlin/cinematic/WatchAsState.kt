@file:Suppress("NOTHING_TO_INLINE")

package cinematic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.DisposableEffect

@Composable
inline fun <S> Live<S>.watchAsState(): S = rememberLive(this)

@Composable
fun <S> rememberLive(live: Live<S>): S {
    var state by remember(live) { mutableStateOf(live.value) }
    DisposableEffect(live) {
        val watcher = live.watch(WatchMode.Lazily) { state = it }
        onDispose { watcher.stop() }
    }
    return state
}