package cinematic

interface SignalFactory {
    fun <T> create(state: T): SettableSignal<T>

    fun <T> compute(fn: () -> T): GettableSignal<T>

    fun effect(fn: () -> Unit)
}