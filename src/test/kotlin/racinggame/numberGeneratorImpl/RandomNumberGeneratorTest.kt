package racinggame.numberGeneratorImpl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {

    @DisplayName("랜덤 번호는 0과 9 사이에 생성된다.")
    @Test
    fun generate() {
        val randomNumberGenerator = RandomNumberGenerator()
        assertThat(randomNumberGenerator.generate())
            .isBetween(0, 9)
    }
}
