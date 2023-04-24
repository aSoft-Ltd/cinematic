@file:JsExport

package viewmodel

import kotlin.js.JsExport

@Deprecated("use cinematic instead")
interface StatefulViewModelConfig<out S> : ViewModelConfig {
    val state: S
}