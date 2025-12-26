package cinematic.internal

import cinematic.MutableLive
import cinematic.MutableLiveSet

@PublishedApi
internal class MutableLiveSetWrapper<E>(
    private val live: MutableLive<Set<E>>
) : MutableLiveSet<E>, MutableLive<Set<E>> by live{

    override fun add(element: E) {
        update { it.add(element) }
    }

    override fun remove(element: E) {
        update { it.remove(element) }
    }

    override fun removeAll(elements: Collection<E>) {
        update { it.removeAll(elements) }
    }

    override fun addAll(elements: Collection<E>) {
        update { it.addAll(elements) }
    }

    override fun clear() {
        live.value = emptySet()
    }

    override fun <R> update(block: (MutableSet<E>) -> R): R {
        val map = live.value.toMutableSet()
        val result = block(map)
        live.value = map.toSet()
        return result
    }
}