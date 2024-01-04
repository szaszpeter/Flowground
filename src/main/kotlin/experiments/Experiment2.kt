package experiments

import flows.numberGeneratorFlow
import flows.stateFlow
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking


fun simpleFlowWithStateFlowDemo() {
    runBlocking {
        val deferreds = listOf(
            async { collectFlow() },
            async { collectStateFlow() }
        )
        deferreds.awaitAll()
    }
}

/***       Collect simple flow       ***/

private suspend fun collectFlow() {
    System.out.println("Collector 1 starting collection...")
    numberGeneratorFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            System.out.println("Item $item collected by 1st collector")
//            _stateFlow.value = item
        }
}

private suspend fun collectStateFlow() {
    stateFlow.collect { item -> System.out.println("Collected from state flow: $item") }
}