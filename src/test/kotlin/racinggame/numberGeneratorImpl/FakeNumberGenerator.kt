package racinggame.numberGeneratorImpl

import racinggame.NumberGenerator

class FakeNumberGenerator(private val fixedNumber: Int) : NumberGenerator {
    override fun generate(): Int = fixedNumber
}
