import flows.numberGeneratorFlow
import flows.tickFlow
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/** Shared Flow obtained vith shareIn function */
val shareIn_sharedFlow =
    numberGeneratorFlow.shareIn(coroutineScope, SharingStarted.WhileSubscribed(), replay = 2)







/** Shared Flow obtained vith stateIn function */
val stateIn_stateFlow =
    numberGeneratorFlow.stateIn(coroutineScope, SharingStarted.WhileSubscribed(), initialValue = -1)










/** State Flow */
private val _stateFlow = MutableStateFlow(0)
val stateFlow: StateFlow<Int> = _stateFlow.asStateFlow()






/** Example of Intermediary Operator - not used for now.  */
val filteredFlow: Flow<Int> = numberGeneratorFlow
    .map { item -> item * 10 }
    .onEach { item -> System.out.println("Item ${item} intercepted and multiplied by 10") }
    .catch { exception -> System.out.println("Exception catched by Intermediary Operator") }
















/***           Flow experimentation methods             ***/

fun mutableSharedFlowWith2ListenersDemo() {
    runBlocking {
        val deferreds = listOf(
            async { collectMutableSharedFlow() },
            async { collectMutableSharedFlow2() }
        )
        deferreds.awaitAll()
    }
}

fun simpleFlowWithStateFlowDemo() {
    runBlocking {
        val deferreds = listOf(
            async { collectFlow() },
            async { collectStateFlow() }
        )
        deferreds.awaitAll()
    }
}

fun shareIn_sharedFlowWith2CollectorsDemo() {
    runBlocking {
        val deferreds = listOf(
            async { collectSharedFlow() },
            async { collectSharedFlow2() }
        )
        deferreds.awaitAll()
    }
}

fun stateIn_stateFlowWith2CollectorsDemo() {
    runBlocking {
        val deferreds = listOf(
            async { collectStateFlow_created_with_stateIn() },
            async { collectStatedFlow2_created_with_stateIn() }
        )
        deferreds.awaitAll()
    }
}

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

suspend fun collectFlow() {
    System.out.println("Collector 1 starting collection...")
    numberGeneratorFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            System.out.println("Item $item collected by 1st collector")
            _stateFlow.value = item
        }
}

suspend fun collectFlow2() {
    System.out.println("Collector 2 starting collection...")
    numberGeneratorFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            System.out.println("Item $item collected by 2nd collector")
            _stateFlow.value = item
        }
}












/***       Collect simple flow with  =====  shareIn function  =====        ***/

suspend fun collectSharedFlow() {
    System.out.println("Collector 1 starting collection...")
    shareIn_sharedFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            System.out.println("Item $item collected by 1st collector")
            _stateFlow.value = item
        }
}

suspend fun collectSharedFlow2() {
    delay(3000)
    System.out.println("Collector 2 starting collection...")
    shareIn_sharedFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            System.out.println("Item $item collected by 2nd collector")
            _stateFlow.value = item
        }
}










/***       Collect simple flow with  =====  stateIn function  =====        ***/

suspend fun collectStateFlow_created_with_stateIn() {
    System.out.println("Collector 1 starting collection...")
    stateIn_stateFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            System.out.println("Item $item collected by 1st collector")
            _stateFlow.value = item
        }
}

suspend fun collectStatedFlow2_created_with_stateIn() {
    delay(3000)
    System.out.println("Collector 2 starting collection...")
    stateIn_stateFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            System.out.println("Item $item collected by 2nd collector")
            _stateFlow.value = item
        }
}











suspend fun collectMutableSharedFlow() {
    System.out.println("Collector 1 starting collection...")
    tickFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            println("1st collectory received: $item")
        }
}

suspend fun collectMutableSharedFlow2() {
    System.out.println("Collector 2 starting collection...")
    tickFlow
        .catch { exception -> System.out.println(exception) }
        .collect { item ->
            println("2nd collectory received: $item")
        }
}












suspend fun collectStateFlow() {
    stateFlow.collect { item -> System.out.println("Collected from state flow: $item") }
}