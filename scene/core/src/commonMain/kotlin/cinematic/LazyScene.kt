@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import kase.LazyState
import kase.Pending
import kase.Success
import kotlin.js.JsExport
import kotlin.js.JsName

abstract class LazyScene<S>(state: LazyState<S>) : Scene<LazyState<S>>(state) {
    @JsName("asPending")
    constructor() : this(Pending)

    @JsName("asSuccess")
    constructor(state: S) : this(Success(state))

    open fun deInitialize() {
        ui.value = Pending
    }
}