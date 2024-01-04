package flows

import experiments.execute.coroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

/** Shared Flow obtained vith stateIn function */
val stateIn_stateFlow =
    numberGeneratorFlow.stateIn(coroutineScope, SharingStarted.WhileSubscribed(), initialValue = -1)
