package intermediaryoperators

import flows.numberGeneratorFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking


/** Example of Intermediary Operator - not used for now.  */
fun filteredFlow() {
    runBlocking {
        numberGeneratorFlow
            .map { item -> item * 10 }
            .onEach { item -> System.out.println("Item ${item} intercepted and multiplied by 10") }
            .catch { exception -> System.out.println("Exception catched by Intermediary Operator") }
    }
}