@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

package cinematic

import react.useEffectWithCleanup
import react.useState

@JsExport
fun <S> useNullableLive(live: Live<S>?): S? {
    var state by useState(live?.value)
    useEffectWithCleanup(live) {
        val watcher = if (state == null) live?.watchEagerly {
            state = it
        } else live?.watchLazily {
            state = it
        }
        onCleanup { watcher?.stop() }
    }
    return state
}

@JsExport
fun <S> useLive(live: Live<S>): S {
    var state by useState(live.value)
    useEffectWithCleanup(live) {
        val watcher = live.watchLazily { state = it }
        onCleanup { watcher.stop() }
    }
    return state
}

inline fun <S> Live<S>.watchAsState() = useLive(this)

inline fun <S> Live<S>?.watchAsState() = useNullableLive(this)