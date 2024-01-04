package intermediaryoperators

import flows.numberGeneratorFlow
import flows.startTickGenerator
import flows.tickFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.runBlocking

/***       Combine two flows       ***/

fun combineFlows() {
    runBlocking {
        startTickGenerator()
        println("Combine started collection...")
        numberGeneratorFlow.combine(tickFlow) { i, j ->
            "[[[$i + $j]]]"
        }.collect {
            println("Combined item $it collected")
            println("")
        }
    }
}