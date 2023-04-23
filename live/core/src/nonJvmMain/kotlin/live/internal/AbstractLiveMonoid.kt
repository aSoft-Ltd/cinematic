package live.internal

import live.MutableLive

@Deprecated("use cinematic instead")
internal actual abstract class AbstractLiveMonoid<S> : AbstractWatchable<S>(), MutableLive<S>