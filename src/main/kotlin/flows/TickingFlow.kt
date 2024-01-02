package flows

import coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import java.util.*

/** Mutable Shared Flow - emmitting ticks with configurable delay between them. */

private val _tickFlow = MutableSharedFlow<String>(replay = 0)
val tickFlow: SharedFlow<String> = _tickFlow

fun startTickGenerator() {
    coroutineScope.launch {
        while (true) {
            println("New Tick emmited")
            _tickFlow.emit("Tick: ${Date(System.currentTimeMillis())}")
            delay(emission_delay_from_user_input)
        }
    }
}