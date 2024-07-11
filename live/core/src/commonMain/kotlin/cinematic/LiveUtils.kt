@file:Suppress("NOTHING_TO_INLINE")

package cinematic

import cinematic.internal.CompoundWatcher


fun <S1, S2> watch(
    live1: Live<S1>,
    live2: Live<S2>,
    callback: (S1, S2) -> Unit
): Watcher {
    val watcher1 = live1.watchLazily {
        callback(it, live2.value)
    }
    val watcher2 = live2.watchLazily {
        callback(live1.value, it)
    }
    return CompoundWatcher(setOf(watcher1, watcher2))
}

fun <S1, S2, S3> watchLazily(
    live1: Live<S1>,
    live2: Live<S2>,
    live3: Live<S3>,
    callback: (S1, S2, S3) -> Unit
): Watcher {
    val watcher1 = live1.watchLazily {
        callback(it, live2.value, live3.value)
    }
    val watcher2 = live2.watchLazily {
        callback(live1.value, it, live3.value)
    }
    val watcher3 = live3.watchLazily {
        callback(live1.value, live2.value, it)
    }
    return CompoundWatcher(setOf(watcher1, watcher2, watcher3))
}

fun <S1, S2, S3> watchEagerly(
    live1: Live<S1>,
    live2: Live<S2>,
    live3: Live<S3>,
    callback: (S1, S2, S3) -> Unit
): Watcher {
    val watcher1 = live1.watchLazily {
        callback(it, live2.value, live3.value)
    }
    val watcher2 = live2.watchLazily {
        callback(live1.value, it, live3.value)
    }
    val watcher3 = live3.watchLazily {
        callback(live1.value, live2.value, it)
    }
    callback(live1.value, live2.value, live3.value)
    return CompoundWatcher(setOf(watcher1, watcher2, watcher3))
}