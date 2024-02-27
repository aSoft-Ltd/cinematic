@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")
@file:OptIn(ExperimentalJsExport::class)

package cinematic

import kase.LazyState
import kase.Pending
import kase.Success
import kotlinx.JsExport
import kotlinx.JsExportIgnore
import kotlin.js.ExperimentalJsExport

abstract class LazyScene<out S>(state: LazyState<S>) : Scene<LazyState<S>>(state) {
    @JsExportIgnore
    constructor() : this(Pending)

    @JsExportIgnore
    constructor(state: S) : this(Success(state))

    open fun deInitialize() {
        ui.value = Pending
    }
}