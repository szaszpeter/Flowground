package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.flow.fold

/***       Fold a simple flow       ***/

suspend fun foldFlow() {
    println("Folder starting collection...")
    println("Folded flow end result: ${
        numberGeneratorFlow
            .fold("String: ") { accumulator, value ->
                println("accumulation: $accumulator, incoming new value: $value")
                accumulator + value
            }
    }")
}