package cinematic

import cinematic.internal.DEFAULT_HISTORY_CAPACITY

object MutableLiveBuilder {
    @JvmStatic
    @JvmOverloads
    fun <S> mutableLiveOf(
        value: S,
        capacity: Int = DEFAULT_HISTORY_CAPACITY
    ): MutableLive<S> = cinematic.mutableLiveOf(value, capacity)
}