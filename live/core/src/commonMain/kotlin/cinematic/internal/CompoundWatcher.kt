package cinematic.internal

import cinematic.Watcher

internal class CompoundWatcher(private val watchers: Collection<Watcher>) : Watcher {
    override fun stop() {
        watchers.forEach { it.stop() }
    }
}