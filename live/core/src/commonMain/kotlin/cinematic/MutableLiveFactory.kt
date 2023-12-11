@file:JvmName("MutableLiveFactory")
@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

package cinematic

import cinematic.internal.DEFAULT_HISTORY_CAPACITY
import cinematic.internal.MutableLiveImpl
import cinematic.internal.SingleWatchableLiveImpl
import kotlinx.JsExport
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

@JvmOverloads
inline fun <S> mutableLiveOf(
    value: S,
    capacity: Int = DEFAULT_HISTORY_CAPACITY
): MutableLive<S> = MutableLiveImpl(value, capacity)

@JvmOverloads
inline fun <S> singleWatchableLiveOf(
    value: S,
    capacity: Int = DEFAULT_HISTORY_CAPACITY
): MutableLive<S> = SingleWatchableLiveImpl(value, capacity)