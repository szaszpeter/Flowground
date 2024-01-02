import flows.emission_delay_from_user_input
import flows.startTickGenerator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

// Resources
// https://medium.com/@mortitech/sharein-vs-statein-in-kotlin-flows-when-to-use-each-1a19bd187553
// https://medium.com/androiddevelopers/things-to-know-about-flows-sharein-and-statein-operators-20e6ccb2bc74
// TODO CONTINUE THIS -> -> -> https://blog.canopas.com/android-9-useful-kotlin-flow-operators-you-need-to-know-b9daef4b630f
// TODO READ THIS -> -> -> https://proandroiddev.com/evolving-with-kotlin-advanced-functional-programming-techniques-ed4b8e0baea3


val coroutineContext: CoroutineContext = Job()
val coroutineScope = CoroutineScope(coroutineContext)


/**  Execution Starting Point  */
fun main() {
    println("Enter emission delay in milliseconds:")
    emission_delay_from_user_input = readln().toLong()

    println("Please select experiment number:")
    println("1). One simple flow collected by two collectors ")
    println("2). One simple flow collected by two collectors via a shareIn function ")
    println("3). One simple flow collected by two collectors via a stateIn function ")
    println("4). One simple flow collected by one collector and one state flow  ")
    println("5). One mutable shared flow collected by two collectors  ")

    when(readln().toInt()) {
        1 -> simpleFlowWith2CollectorsDemo()
        2 -> shareIn_sharedFlowWith2CollectorsDemo()
        3 -> stateIn_stateFlowWith2CollectorsDemo()
        4 -> simpleFlowWithStateFlowDemo()
        5 -> {
            startTickGenerator()
            mutableSharedFlowWith2ListenersDemo()
        }
        else -> {
            // do nothing
        }
    }
}







