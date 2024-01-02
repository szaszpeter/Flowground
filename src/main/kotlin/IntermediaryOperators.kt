import flows.emission_delay_from_user_input
import flows.numberGeneratorFlow
import flows.startTickGenerator
import flows.tickFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


fun main() {
    println("Enter emission delay in milliseconds:")
    emission_delay_from_user_input = readln().toLong()
    runBlocking {
        flatmapMergeFlow()
    }
}


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


/***       Debounce a simple flow       ***/

@OptIn(FlowPreview::class)
suspend fun debounceFlow() {
    println("Debounce starting collection...")
    numberGeneratorFlow.debounce(300).collect {
        println("Item $it collected")
    }
}

/***       Sample a simple flow       ***/

suspend fun sampleFlow() {
    println("Sampling starting collection...")
    numberGeneratorFlow.sample(300).collect {
        println("Item $it collected")
    }
}



@OptIn(ExperimentalCoroutinesApi::class)
suspend fun flatmapMergeFlow() {
    println("Flatmap Merge started collection...")
    numberGeneratorFlow.flatMapMerge {
        flowOf("$it a", "$it b")
    }.collect {
        println("Flattened item $it collected")
    }
}