package cinematic

import cinematic.internal.SignalFactoryImpl
import kommander.expect
import kotlin.test.Test

class SignalsTest {

    private val factory = SignalFactoryImpl()

    @Test
    fun should_be_able_to_create_a_signal() {
        val counter = factory.create(0)
        expect(counter()).toBe(0)
    }

    @Test
    fun should_be_able_to_set_a_value_on_a_signal() {
        val counter = factory.create(0)
        expect(counter()).toBe(0)
        counter(4)
        expect(counter()).toBe(4)
    }

    @Test
    fun should_be_able_to_compute_a_signal() {
        val counter = factory.create(0)
        var executes = 0
        val isEven = factory.compute {
            executes++
            counter() % 2 == 0
        }
        expect(executes).toBe(1)
        expect(isEven()).toBe(true)
        counter(1)
        expect(executes).toBe(2)
        expect(isEven()).toBe(false)
    }

    @Test
    fun should_be_able_to_react_on_effects() {
        val counter = factory.create(0)
        var effects = 0
        factory.effect {
            effects++
            println("counter() // ${counter()}")
        }
        expect(effects).toBe(1)
        counter(2)
        expect(effects).toBe(2)
    }

    @Test
    fun should_be_able_to_react_on_multiple_signal_changes() {
        val numbers = factory.create(0)
        val letters = factory.create('A')

        val double = factory.compute {
            val num = numbers()
            println("double has been computed")
            2 * num
        }
        val lower = factory.compute {
            val let = letters()
            println("lower has been computed")
            let.lowercaseChar()
        }

        numbers(1)
        expect(double()).toBe(2)
        letters('B')
        expect(lower()).toBe('b')
    }

    @Test
//    @Ignore
    fun should_be_able_to_chain_computed_signals() {
        val counter = factory.create(1)

        val parity = factory.compute {
            if (counter() and 1 == 0) "even" else "odd"
        }

        val sentence = factory.compute {
            "counter is ${parity()}"
        }

        counter(3)
        parity()
        sentence()

        parity()
        sentence()

        parity()
        sentence()

        counter(5)
        parity()
        sentence()

        parity()
        sentence()

        parity()
        expect(sentence()).toBe("counter is odd")
    }
}