package live

import kotlin.js.JsExport

@Deprecated("use cinematic instead")
@JsExport
interface Watcher {
    fun stop()
}