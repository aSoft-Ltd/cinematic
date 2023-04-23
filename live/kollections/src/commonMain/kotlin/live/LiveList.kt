@file:JsExport

package live

import kollections.CollectionLike
import kollections.List
import kotlin.js.JsExport

@Deprecated("use cinematic instead")
interface LiveList<out E> : CollectionLike<E>, Live<List<E>>