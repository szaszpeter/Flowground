package intermediaryoperators

import flows.numberGeneratorFlow
import flows.startTickGenerator
import flows.tickFlow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking


/***       Zip two flows       ***/

fun zipFlows() {
    runBlocking {
        startTickGenerator()
        println("Zip started collection...")
        numberGeneratorFlow.zip(tickFlow) { i, j ->
            "[[[$i + $j]]]"
        }.collect {
            println("Zipped item $it collected")
            println("")
        }
    }
}