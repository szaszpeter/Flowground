package intermediaryoperators

import flows.numberGeneratorFlow
import flows.startTickGenerator
import flows.tickFlow
import kotlinx.coroutines.flow.combine

/***       Combine two flows       ***/

suspend fun combineFlows() {
    startTickGenerator()
    println("Combine started collection...")
    numberGeneratorFlow.combine(tickFlow) { i, j ->
        "[[[$i + $j]]]"
    }.collect {
        println("Combined item $it collected")
        println("")
    }
}