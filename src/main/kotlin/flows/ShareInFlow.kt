package flows

import experiments.execute.coroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn

/** Shared Flow obtained vith shareIn function */
val shareIn_sharedFlow =
    numberGeneratorFlow.shareIn(coroutineScope, SharingStarted.WhileSubscribed(), replay = 2)