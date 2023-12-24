@file:JsExport

package cinematic

import kollections.List
import kotlinx.JsExport
import kotlinx.JsName

@JsName("LiveArray")
interface LiveList<out E> : Live<List<E>>