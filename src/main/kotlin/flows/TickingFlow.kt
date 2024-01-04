package flows

import experiments.execute.coroutineScope
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
            val tick = Date(System.currentTimeMillis())
            println("New Tick emmited ($tick)")
            _tickFlow.emit("Tick: ${tick}")
            delay(emission_delay_from_user_input)
        }
    }
}