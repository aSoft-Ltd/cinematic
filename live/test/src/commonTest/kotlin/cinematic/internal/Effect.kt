package cinematic.internal

internal class Effect(private val fn: () -> Unit) : SignalDependency {

    override fun execute() {
        fn()
    }

    override fun update() {
        execute()
    }
}