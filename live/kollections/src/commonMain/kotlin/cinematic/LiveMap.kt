@file:JsExport

package cinematic

import kollections.Collection
import kollections.Map
import kollections.Set
import kollections.MapEntry
import kotlinx.JsExport

interface LiveMap<K, V> : Live<Map<K, V>> {
    val size : Int

    val keys : Set<K>

    val values : Collection<V>

    val entries : Set<MapEntry<K,V>>

    fun get(key: K): V?

    fun getValue(key: K): V
}