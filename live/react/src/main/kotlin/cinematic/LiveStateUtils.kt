@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

package cinematic

import koncurrent.Executor
import koncurrent.SynchronousExecutor
import react.useEffect
import react.useEffectWithCleanup
import react.useState

@JsExport
fun <S> useNullableLive(live: Live<S>?, executor: Executor? = null): S? {
    var state by useState(live?.value)
    useEffectWithCleanup (live, executor) {
        val e = executor ?: SynchronousExecutor
        val watcher = if (state == null) live?.watchEagerly(e) {
            state = it
        } else live?.watchLazily(e) {
            state = it
        }
        onCleanup { watcher?.stop() }
    }
    return state
}

@JsExport
fun <S> useLive(live: Live<S>, executor: Executor? = null): S {
    var state by useState(live.value)
    useEffectWithCleanup(live, executor) {
        val e = executor ?: SynchronousExecutor
        val watcher = live.watchLazily(e) { state = it }
        onCleanup { watcher.stop() }
    }
    return state
}

inline fun <S> Live<S>.watchAsState(executor: Executor = SynchronousExecutor) = useLive(this, executor)

inline fun <S> Live<S>?.watchAsState(executor: Executor = SynchronousExecutor) = useNullableLive(this, executor)