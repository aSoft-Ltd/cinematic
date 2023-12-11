@file:JsExport

package cinematic

import kotlinx.JsExport

actual abstract class BaseScene {
    protected actual open fun onCleared() {}
}