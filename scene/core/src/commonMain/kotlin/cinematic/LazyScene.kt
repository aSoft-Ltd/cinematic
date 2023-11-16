@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")
@file:OptIn(ExperimentalJsExport::class)

package cinematic

import kase.LazyState
import kase.Pending
import kase.Success
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.js.JsName

abstract class LazyScene<out S>(state: LazyState<S>) : Scene<LazyState<S>>(state) {
    @JsExport.Ignore
    constructor() : this(Pending)

    @JsExport.Ignore
    constructor(state: S) : this(Success(state))

    open fun deInitialize() {
        ui.value = Pending
    }
}