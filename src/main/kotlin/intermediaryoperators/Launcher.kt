package intermediaryoperators

import flows.emission_delay_from_user_input


fun main() {
    println("Enter emission delay in milliseconds:")
    emission_delay_from_user_input = readln().toLong()

    println("Please select intermediary operator from below:")
    println("1). Buffer ")
    println("2). Combine ")
    println("3). Debounce ")
    println("4). Filter  ")
    println("5). FlatmapConcat  ")
    println("6). FlatmapMerge  ")
    println("7). Fold  ")
    println("8). Reduce  ")
    println("9). Sample  ")
    println("10). Zip  ")

    when(readln().toInt()) {
        1 -> bufferExample()
        2 -> combineFlows()
        3 -> debounceFlow()
        4 -> filteredFlow()
        5 -> flatmapConcatFlows()
        6 -> flatmapMergeFlows()
        7 -> foldFlow()
        8 -> reduceFlow()
        9 -> sampleFlow()
        10 -> zipFlows()
        else -> {
            // do nothing
        }
    }
}























