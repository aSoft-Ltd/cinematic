@file:JsExport

package viewmodel

import kotlin.js.JsExport

actual abstract class BaseViewModel actual constructor(private val config: ViewModelConfig) {

    protected actual val logger get() = config.logger.with("source" to this::class.simpleName)

    protected actual val executor get() = config.executor

    protected actual fun log(msg: String) = when {
        msg.contains("error", ignoreCase = true) -> logger.error(msg)
        msg.contains("fail", ignoreCase = true) -> logger.failure(msg)
        else -> logger.info(msg)
    }

    protected actual open fun onCleared() {}
}