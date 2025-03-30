package racinggame.numberGeneratorImpl

import racinggame.NumberGenerator

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int = (0..9).random()
}

