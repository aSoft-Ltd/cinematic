package cinematic.internal

import cinematic.MutableLive
import cinematic.MutableLiveList

@PublishedApi
internal class MutableLiveListWrapper<E>(
    private val live: MutableLive<List<E>>
) : MutableLiveList<E>, MutableLive<List<E>> by live {


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
        live.value = emptyList()
    }

    override fun <R> update(block: (MutableList<E>) -> R): R {
        val map = live.value.toMutableList()
        val result = block(map)
        live.value = map.toList()
        return result
    }
}