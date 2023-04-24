@file:JsExport

package cinematic

import kotlin.js.JsExport

actual abstract class BaseScene {
    protected actual open fun onCleared() {}
}