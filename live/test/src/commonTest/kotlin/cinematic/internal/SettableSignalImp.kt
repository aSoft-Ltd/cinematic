package cinematic.internal

import cinematic.SettableSignal

internal class SettableSignalImp<T>(
    private var value: T,
    private var factory: SignalFactoryImpl
) : SettableSignal<T> {

    private val sinks = mutableListOf<SignalDependency>()

    override fun invoke(state: T) {
        if (value == state) return
        value = state
        publish()
    }

    override fun invoke(): T {
        factory.sink?.let { sinks.add(it) }
        return value
    }

    private fun publish() {
        for (sink in sinks) sink.update()
    }
}