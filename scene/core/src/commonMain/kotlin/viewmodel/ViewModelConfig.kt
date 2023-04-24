@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package viewmodel

import cache.Cache
import koncurrent.Executor
import kotlinx.serialization.StringFormat
import krest.WorkManager
import logging.Logger
import kotlin.js.JsExport
import kotlin.jvm.*

@Deprecated("use cinematic instead")
interface ViewModelConfig {
    val executor: Executor
    val logger: Logger
    val codec: StringFormat
    val cache: Cache
    val workManager: WorkManager

    fun <S> of(state: S): StatefulViewModelConfig<S>
}