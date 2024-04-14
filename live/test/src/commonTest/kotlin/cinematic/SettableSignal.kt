package cinematic

interface SettableSignal<T> : GettableSignal<T> {
    operator fun invoke(state: T)
}