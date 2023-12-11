@file:JsExport

package cinematic

import kollections.Map
import kollections.MapLike
import kotlinx.JsExport

interface LiveMap<K, V> : MapLike<K, V>, Live<Map<K, V>>