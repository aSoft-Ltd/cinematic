package live

import live.internal.LiveExpectationImpl

@Deprecated("use cinematic instead")
inline fun <S> expect(live: Live<S>): LiveExpectation<S> = LiveExpectationImpl(live)