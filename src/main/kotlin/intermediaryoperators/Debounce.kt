package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce

/***       Debounce a simple flow       ***/

@OptIn(FlowPreview::class)
suspend fun debounceFlow() {
    println("Debounce starting collection...")
    numberGeneratorFlow.debounce(300).collect {
        println("Item $it collected")
    }
}