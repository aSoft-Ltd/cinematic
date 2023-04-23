@file:Suppress("NOTHING_TO_INLINE")

package cinematic

import cinematic.internal.LiveExpectationImpl

inline fun <S> expect(live: Live<S>): ExpectLive<S> = LiveExpectationImpl(live)