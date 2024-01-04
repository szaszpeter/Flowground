package flows

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/** State Flow */
private val _stateFlow = MutableStateFlow(0)
val stateFlow: StateFlow<Int> = _stateFlow.asStateFlow()

