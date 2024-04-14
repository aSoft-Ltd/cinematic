package cinematic.internal

import cinematic.GettableSignal
import cinematic.SettableSignal
import cinematic.SignalFactory

internal class SignalFactoryImpl : SignalFactory {
    var sink: SignalDependency? = null

    override fun <T> create(state: T): SettableSignal<T> {
        return SettableSignalImp(state, this)
    }

    override fun <T> compute(fn: () -> T): GettableSignal<T> {
        val computed = ComputedSignalImpl(fn, this)
        runAndExtract(computed)
        return computed
    }

    override fun effect(fn: () -> Unit) {
        runAndExtract(Effect(fn))
    }

    private fun runAndExtract(snk: SignalDependency) {
        sink = snk
        snk.execute()
        sink = null
    }
}