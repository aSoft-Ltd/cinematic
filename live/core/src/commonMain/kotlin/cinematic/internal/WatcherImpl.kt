package cinematic.internal

import koncurrent.Executor
import cinematic.Watcher

internal class WatcherImpl<in V> internal constructor(
    private val container: MutableList<WatcherImpl<V>>,
    private val executor: Executor,
    private val callable: (V) -> Unit
) : Watcher {
    fun execute(value: V) = executor.execute { callable(value) }
    override fun stop() {
        container.remove(this)
    }
}