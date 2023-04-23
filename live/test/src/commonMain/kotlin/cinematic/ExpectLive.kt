package cinematic

import kommander.ExpectCollection
import kotlin.reflect.KClass

interface ExpectLive<out S> : ExpectCollection<S> {

    fun toBeIn(state: @UnsafeVariance S)

    fun toHaveGoneThrough(vararg states: @UnsafeVariance S): List<S>

    fun toHaveGoneThrough(vararg states: KClass<out Any>): List<S>
}