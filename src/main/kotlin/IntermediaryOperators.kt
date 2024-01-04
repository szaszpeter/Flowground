import flows.emission_delay_from_user_input
import intermediaryoperators.zipFlows
import kotlinx.coroutines.runBlocking


fun main() {
    println("Enter emission delay in milliseconds:")
    emission_delay_from_user_input = readln().toLong()
    runBlocking {
        zipFlows()
    }
}























