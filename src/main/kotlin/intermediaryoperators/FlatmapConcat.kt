package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf

/***       Concatenate two flows       ***/

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun flatmapConcatFlow() {
    println("Flatmap Concat started collection...")
    numberGeneratorFlow.flatMapConcat {
        flowOf("$it a", "$it b")
    }.collect {
        println("Flattened concatenated item $it collected")
    }
}