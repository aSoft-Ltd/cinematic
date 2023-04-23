package cinematic.internal

import cinematic.MutableLive

internal abstract class AbstractLive<S> : AbstractWatchable<S>(), MutableLive<S> {

    protected val mapQueue = mutableListOf<LiveQueueItem<S, Any?>>()

    override fun <R> map(transformer: (S) -> R): MutableLive<R> {
        val live = MutableLiveImpl(transformer(value), DEFAULT_HISTORY_CAPACITY)
        val item = LiveQueueItem(live, transformer)
        mapQueue.add(item)
        return live
    }
}