package experiments

import flows.shareIn_sharedFlow
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking

fun shareIn_sharedFlowWith2CollectorsDemo() {
    runBlocking {
        val deferreds = listOf(
            async { collectSharedFlow() },
            async { collectSharedFlow2() }
        )
        deferreds.awaitAll()
    }
}


/***       Collect simple flow with  =====  shareIn function  =====        ***/

private suspend fun collectSharedFlow() {
    println("Collector 1 starting collection...")
    shareIn_sharedFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            println("Item $item collected by 1st collector")
//            _stateFlow.value = item
        }
}

private suspend fun collectSharedFlow2() {
    delay(3000)
    System.out.println("Collector 2 starting collection...")
    shareIn_sharedFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            println("Item $item collected by 2nd collector")
//            _stateFlow.value = item
        }
}