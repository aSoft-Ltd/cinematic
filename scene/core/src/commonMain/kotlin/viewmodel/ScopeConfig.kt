@file:JsExport

package viewmodel

import kotlin.js.JsExport

@Deprecated("use cinematic instead")
interface ScopeConfig<out A> : ViewModelConfig {
    val api: A
    fun <R> map(transformer: (A) -> R): ScopeConfig<R>
}