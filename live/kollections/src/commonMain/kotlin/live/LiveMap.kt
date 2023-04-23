@file:JsExport

package live

import kollections.Map
import kollections.MapLike
import kotlin.js.JsExport

@Deprecated("use cinematic instead")
interface LiveMap<K, V> : MapLike<K, V>, Live<Map<K, V>>