package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.runBlocking

/***       Debounce a simple flow       ***/

@OptIn(FlowPreview::class)
fun debounceFlow() {
    runBlocking {
        println("Debounce starting collection...")
        numberGeneratorFlow.debounce(300).collect {
            println("Item $it collected")
        }
    }
}