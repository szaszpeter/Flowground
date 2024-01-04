package experiments

import flows.numberGeneratorFlow
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking

fun simpleFlowWith2CollectorsDemo() {
    runBlocking {
        val deferreds = listOf(
            async { collectFlow() },
            async { collectFlow2() }
        )
        deferreds.awaitAll()
    }
}

/***       Collect simple flow       ***/

private suspend fun collectFlow() {
    println("Collector 1 starting collection...")
    numberGeneratorFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            println("Item $item collected by 1st collector")
//            _stateFlow.value = item
        }
}

private suspend fun collectFlow2() {
    println("Collector 2 starting collection...")
    numberGeneratorFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            System.out.println("Item $item collected by 2nd collector")
//            _stateFlow.value = item
        }
}