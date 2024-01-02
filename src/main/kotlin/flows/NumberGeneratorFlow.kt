package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

/** Basic Flow - emmitting numbers from 0 to 29 */
var i = 0
var emission_delay_from_user_input = 0L
val numberGeneratorFlow: Flow<Int> = flow<Int> {
    while (i < 30) {
        println("Item $i emmited")
        emit(i)
        i++
        delay(emission_delay_from_user_input)
    }
}