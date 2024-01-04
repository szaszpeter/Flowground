package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.runBlocking

/***       Fold a simple flow       ***/

fun foldFlow() {
    runBlocking {
        println("Folder starting collection...")
        println("Folded flow end result: ${
            numberGeneratorFlow
                .fold("String: ") { accumulator, value ->
                    println("accumulation: $accumulator, incoming new value: $value")
                    accumulator + value
                }
        }")
    }
}