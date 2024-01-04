package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

/***       Merge two flows       ***/

@OptIn(ExperimentalCoroutinesApi::class)
fun flatmapMergeFlows() {
    runBlocking {
        println("Flatmap Merge started collection...")
        numberGeneratorFlow.flatMapMerge {
            flowOf("$it a", "$it b")
        }.collect {
            println("Flattened item $it collected")
        }
    }
}