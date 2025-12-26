package cinematic.internal

import cinematic.Watchable
import cinematic.Watcher

internal abstract class AbstractWatchable<out S> : Watchable<S> {
//    protected abstract fun watchRaw(executor: Executor?, mode: WatchMode?, callback: ((state: S) -> Unit)?): Watcher
//    override fun watchLazily(executor: Executor, callback: (state: S) -> Unit) = watchRaw(executor, WatchMode.Lazily, callback)
//    override fun watchEagerly(executor: Executor, callback: (state: S) -> Unit) = watchRaw(executor, WatchMode.Eagerly, callback)
//    override fun watchLazily(callback: (state: S) -> Unit) = watchRaw(null, WatchMode.Lazily, callback)
//    override fun watchEagerly(callback: (state: S) -> Unit) = watchRaw(null, WatchMode.Eagerly, callback)

    protected abstract fun watchRaw(mode: WatchMode?, callback: ((state: S) -> Unit)?): Watcher
    override fun watchLazily(callback: (state: S) -> Unit) = watchRaw(WatchMode.Lazily, callback)
    override fun watchEagerly(callback: (state: S) -> Unit) = watchRaw(WatchMode.Eagerly, callback)
}