@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import koncurrent.Executor
import kotlinx.JsExport
import kotlinx.JsExportIgnore

/**
 * A wrapper around a [value] that can be watched as it changes
 */
interface Watchable<out S> {

    val value: S

    /**
     * Start watching the [value] immediately with the current value and be updated via a [callback]
     *
     * @return a [Watcher]
     */
    @JsExportIgnore
    fun watchEagerly(executor: Executor, callback: (state: S) -> Unit): Watcher

    /**
     * Start watching the [value] after the next change has occurred and be updated via a [callback]
     *
     * @return a [Watcher]
     */
    @JsExportIgnore
    fun watchLazily(executor: Executor, callback: (state: S) -> Unit): Watcher

    /**
     * Start watching the [value] immediately with the current value and be updated via a [callback]
     *
     * @return a [Watcher]
     */
    fun watchEagerly(callback: (state: S) -> Unit): Watcher

    /**
     * Start watching the [value] after the next change has occurred and be updated via a [callback]
     *
     * @return a [Watcher]
     */
    fun watchLazily(callback: (state: S) -> Unit): Watcher
}