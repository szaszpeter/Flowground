package intermediaryoperators

import flows.emission_delay_from_user_input
import flows.numberGeneratorFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/***       Buffering a flow when bottleneck on collector       ***/

fun bufferExample() {
    runBlocking {
        println("Buffering sample started collection...")
        numberGeneratorFlow
            .onEach {
                println("Buffered item $it onEach method")
            }
            .buffer(30)
            .collect {
                delay(3 * emission_delay_from_user_input)
                println("Buffered item $it collected")
            }
    }
}