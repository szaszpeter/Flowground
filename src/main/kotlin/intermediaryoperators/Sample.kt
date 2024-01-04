package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.runBlocking


/***       Sample a simple flow       ***/

fun sampleFlow() {
    runBlocking {
        println("Sampling starting collection...")
        numberGeneratorFlow.sample(300).collect {
            println("Item $it collected")
        }
    }
}