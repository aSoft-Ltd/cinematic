@file:JvmName("LiveBuilders")
@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

package cinematic

import cinematic.internal.DEFAULT_HISTORY_CAPACITY
import cinematic.internal.MutableLiveImpl
import kotlin.js.JsExport
import kotlin.jvm.JvmName

inline fun <S> mutableLiveOf(
    value: S,
    capacity: Int = DEFAULT_HISTORY_CAPACITY
): MutableLive<S> = MutableLiveImpl(value, capacity)