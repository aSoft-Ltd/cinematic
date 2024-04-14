package cinematic.internal

import cinematic.GettableSignal

internal class ComputedSignalImpl<out T>(
    private val fn: () -> T,
    private val factory: SignalFactoryImpl
) : GettableSignal<T>, SignalDependency {

    private var isStale: Boolean = true
    private var value: T? = null

    private val sinks = mutableListOf<SignalDependency>()

    override fun invoke(): T {
        factory.sink?.let { sinks.add(it) }
        if (isStale) {
            value = fn()
            isStale = false
        }
        return value as T
    }

    override fun execute() {
        fn()
    }

    override fun update() {
        isStale = true
        sinks.forEach { it.update() }
    }
}