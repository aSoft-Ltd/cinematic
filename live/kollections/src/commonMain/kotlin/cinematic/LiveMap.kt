@file:JsExport

package cinematic

import kotlinx.JsExport

interface LiveMap<K, V> : Live<Map<K, V>> {
    val size: Int

    val keys: Set<K>

    val values: Collection<V>

    val entries: Set<Map.Entry<K, V>>

    fun get(key: K): V?

    fun getValue(key: K): V
}