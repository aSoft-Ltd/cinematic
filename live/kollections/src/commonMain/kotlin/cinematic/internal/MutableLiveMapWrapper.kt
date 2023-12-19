package cinematic.internal

import cinematic.MutableLive
import cinematic.MutableLiveMap
import kollections.Map
import kollections.MutableMap
import kollections.entries
import kollections.get
import kollections.getValue
import kollections.keys
import kollections.mapOf
import kollections.put
import kollections.putAll
import kollections.remove
import kollections.size
import kollections.toMutableMap
import kollections.values

@PublishedApi
internal class MutableLiveMapWrapper<K, V>(
    private val live: MutableLive<Map<K, V>>
) : MutableLiveMap<K, V>, MutableLive<Map<K, V>> by live {

    override val size get() = live.value.size

    override val keys get() = live.value.keys

    override val values get() = live.value.values

    override val entries get() = live.value.entries

    override fun get(key: K): V? = live.value[key]

    override fun getValue(key: K): V = live.value.getValue(key)

    override fun clear() {
        live.value = mapOf()
    }

    override fun remove(key: K): V? = update { it.remove(key) }

    override fun put(key: K, value: V): V? = update { it.put(key, value) }

    override fun putAll(from: Map<K, V>) = update { it.putAll(from) }

    override fun set(key: K, value: V) {
        put(key, value)
    }

    override fun <R> update(block: (MutableMap<K, V>) -> R): R {
        val map = live.value.toMutableMap()
        val result = block(map)
        live.value = map
        return result
    }
}