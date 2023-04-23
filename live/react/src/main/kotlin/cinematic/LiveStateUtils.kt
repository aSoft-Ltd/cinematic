@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

package cinematic

import koncurrent.Executor
import koncurrent.SynchronousExecutor
import react.useEffect
import react.useState

@JsExport
fun <S> useNullableLive(live: Live<S>?, executor: Executor? = null): S? {
    var state by useState(live?.value)
    useEffect(live, executor) {
        val e = executor ?: SynchronousExecutor
        val mode = if (state == null) WatchMode.Eagerly else WatchMode.Casually
        val watcher = live?.watch(mode = mode, e) { state = it }
        cleanup { watcher?.stop() }
    }
    return state
}

@JsExport
fun <S> useLive(live: Live<S>, executor: Executor? = null): S {
    var state by useState(live.value)
    useEffect(live, executor) {
        val e = executor ?: SynchronousExecutor
        val watcher = live.watch(mode = WatchMode.Casually, e) { state = it }
        cleanup { watcher.stop() }
    }
    return state
}

inline fun <S> Live<S>.watchAsState(executor: Executor = SynchronousExecutor) = useLive(this, executor)

inline fun <S> Live<S>?.watchAsState(executor: Executor = SynchronousExecutor) = useNullableLive(this, executor)