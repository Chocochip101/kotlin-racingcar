package racinggame

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racinggame.numberGeneratorImpl.FakeNumberGenerator

class RacingGameTest {

    private lateinit var cars: List<Car>

    @BeforeEach
    fun setUp() {
        cars = listOf(Car("eden"), Car("lini"), Car("clove"))
    }

    @DisplayName("랜덤 값이 4 이상이면 자동차가 전진해야 한다.")
    @Test
    fun carsMoveWhenNumberIsGreaterThanOrEqualTo() {
        val alwaysMoveGenerator = FakeNumberGenerator(4)
        val racingGame = RacingGame(cars, alwaysMoveGenerator)

        racingGame.play()

        cars.forEach { car ->
            assertThat(car.getDistance()).isEqualTo(1)
        }
    }

    @DisplayName("랜덤 값이 3 이하이면 자동차가 멈춰야 한다.")
    @Test
    fun carsDoNotMoveWhenNumberIsLessThan() {
        val neverMoveGenerator = FakeNumberGenerator(3)
        val racingGame = RacingGame(cars, neverMoveGenerator)

        racingGame.play()

        cars.forEach { car ->
            assertThat(car.getDistance()).isEqualTo(0)
        }
    }
}
