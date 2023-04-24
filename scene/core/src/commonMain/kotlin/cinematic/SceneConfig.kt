@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import koncurrent.Executor
import lexi.Logger
import kotlin.js.JsExport

interface SceneConfig<out S> {
    val executor: Executor
    val logger: Logger
    val state: S
    fun <T> map(transformer: (S) -> T): SceneConfig<T>
}