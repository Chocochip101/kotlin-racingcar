package racinggame.numberGeneratorImpl

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeBetween

class RandomNumberGeneratorTest : StringSpec({

    "랜덤 번호는 0과 9 사이에 생성된다." {
        val randomNumberGenerator = RandomNumberGenerator()
        val number = randomNumberGenerator.generate()

        number.shouldBeBetween(0, 9)
    }
})
