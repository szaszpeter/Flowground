package experiments

import flows.tickFlow
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking

fun mutableSharedFlowWith2ListenersDemo() {
    runBlocking {
        val deferreds = listOf(
            async { collectMutableSharedFlow() },
            async { collectMutableSharedFlow2() }
        )
        deferreds.awaitAll()
    }
}

private suspend fun collectMutableSharedFlow() {
    println("Collector 1 starting collection...")
    tickFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            println("1st collectory received: $item")
        }
}

private suspend fun collectMutableSharedFlow2() {
    println("Collector 2 starting collection...")
    tickFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            println("2nd collectory received: $item")
        }
}