package cinematic.internal

import cinematic.Watcher

internal class WatcherImpl<in V> internal constructor(
    private val container: MutableList<WatcherImpl<V>>,
    private val callable: (V) -> Unit
) : Watcher {
    fun execute(value: V) = callable(value)

    override fun stop() {
        container.remove(this)
    }
}