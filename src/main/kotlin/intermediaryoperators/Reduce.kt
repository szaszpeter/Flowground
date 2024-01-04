package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.flow.reduce

/***       Reduce simple flow       ***/

suspend fun reduceFlow() {
    println("Reducer starting collection...")
    println("Reduced flow end result: ${
        numberGeneratorFlow
            .reduce { accumulator, value ->
                println("accumulation: $accumulator, incoming new value: $value")
                accumulator + value
            }
    }")
}