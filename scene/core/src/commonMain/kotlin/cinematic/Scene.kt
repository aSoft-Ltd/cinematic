@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import kotlin.js.JsExport

abstract class Scene<out S>(state: S) : BaseScene() {

    val ui: MutableLive<@UnsafeVariance S> = mutableLiveOf(state)
    override fun onCleared() {
        ui.stopAll()
    }
}