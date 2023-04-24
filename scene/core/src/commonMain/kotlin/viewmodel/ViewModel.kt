@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package viewmodel

import live.*
import viewmodel.internal.toDetailedString
import kotlin.js.JsExport

@Deprecated("use cinematic instead")
abstract class ViewModel<out S>(config: StatefulViewModelConfig<S>) : BaseViewModel(config) {

    val ui: MutableLive<@UnsafeVariance S> = mutableLiveOf(config.state)

    init {
        ui.watch(WatchMode.Eagerly, executor) { log("State at ${it?.toDetailedString}") }
    }

    override fun onCleared() {
        ui.stopAll()
    }
}