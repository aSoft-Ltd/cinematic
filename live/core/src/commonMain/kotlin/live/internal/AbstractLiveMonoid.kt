package live.internal

import live.MutableLive

@Deprecated("use cinematic instead")
internal expect abstract class AbstractLiveMonoid<S>() : AbstractWatchable<S>, MutableLive<S>