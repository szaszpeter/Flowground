package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.flow.sample


/***       Sample a simple flow       ***/

suspend fun sampleFlow() {
    println("Sampling starting collection...")
    numberGeneratorFlow.sample(300).collect {
        println("Item $it collected")
    }
}