@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import kotlinx.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmSynthetic

interface MutableLive<S> : Live<S> {
    override val history: MutableList<S>

    override var value: S

    fun undo()

    fun redo()

    /**
     * Transforms this live to another live
     */
    @JvmSynthetic
    override fun <R> map(transformer: (S) -> R): MutableLive<R>

    /**
     * Notify the watchers without changing the underlying value
     */
    @JsName("dispatchValue")
    fun dispatch(value: S)
}