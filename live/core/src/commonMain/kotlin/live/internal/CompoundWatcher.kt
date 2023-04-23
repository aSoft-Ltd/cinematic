package live.internal

import live.Watcher

@Deprecated("use cinematic instead")
internal class CompoundWatcher(private val watchers: Collection<Watcher>) : Watcher {
    override fun stop() {
        watchers.forEach { it.stop() }
    }
}