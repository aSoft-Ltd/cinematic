package cinematic

interface GettableSignal<out T> {
    operator fun invoke(): T

    fun get() = invoke()
}