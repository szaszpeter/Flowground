package experiments

import flows.stateIn_stateFlow
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking


fun stateIn_stateFlowWith2CollectorsDemo() {
    runBlocking {
        val deferreds = listOf(
            async { collectStateFlow_created_with_stateIn() },
            async { collectStatedFlow2_created_with_stateIn() }
        )
        deferreds.awaitAll()
    }
}


/***       Collect simple flow with  =====  stateIn function  =====        ***/

private suspend fun collectStateFlow_created_with_stateIn() {
    println("Collector 1 starting collection...")
    stateIn_stateFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            System.out.println("Item $item collected by 1st collector")
//            _stateFlow.value = item
        }
}

private suspend fun collectStatedFlow2_created_with_stateIn() {
    delay(3000)
    println("Collector 2 starting collection...")
    stateIn_stateFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            System.out.println("Item $item collected by 2nd collector")
//            _stateFlow.value = item
        }
}