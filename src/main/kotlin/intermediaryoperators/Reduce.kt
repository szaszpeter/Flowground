package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

/***       Reduce simple flow       ***/

fun reduceFlow() {
    runBlocking {
        println("Reducer starting collection...")
        println("Reduced flow end result: ${
            numberGeneratorFlow
                .reduce { accumulator, value ->
                    println("accumulation: $accumulator, incoming new value: $value")
                    accumulator + value
                }
        }")
    }
}