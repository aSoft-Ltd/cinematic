@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import kollections.MutableMap
import kollections.Map
import kotlinx.JsExport

interface MutableLiveMap<K, V> : MutableLive<Map<K, V>>, LiveMap<K, V> {

    fun clear()

    fun remove(key: K): V?

    fun put(key: K, value: V): V?

    fun putAll(from: Map<K, V>)

    operator fun set(key: K, value: V)
    fun <R> update(block: (MutableMap<K, V>) -> R): R
}