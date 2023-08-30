package cinematic

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class TestWatchingValues {
    val live = mutableLiveOf(0)

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun should_watch_as_state_in_a_composable_function() = with(rule){
        setContent { Counter(live, onIncrement = { live.value += 1 }) }

        onNodeWithText("Counter: 0").performClick()
        onNodeWithText("Counter: 1").assertExists()
        onNodeWithText("Counter: 1").performClick()
        onNodeWithText("Counter: 2").assertExists()
        Unit
    }

    @Composable
    fun Counter(integer: Live<Int>, onIncrement: () -> Unit) {
        val value = integer.watchAsState()
        Button(onClick = onIncrement) {
            Text("Counter: $value")
        }
    }
}