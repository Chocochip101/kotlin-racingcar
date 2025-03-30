package racinggame

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarScoresTest {

    private lateinit var carScores: CarScores
    private lateinit var cars: List<Car>

    @BeforeEach
    fun setUp() {
        cars = listOf(
            Car("eden", 3),
            Car("clover", 5),
            Car("lini", 5)
        )
        carScores = CarScores(cars)
    }

    @DisplayName("우승자가 2명일 때, 두 명이 우승자로 반환되어야 한다.")
    @Test
    fun findWinners() {
        val winners = carScores.findWinners()
        assertThat(winners).hasSize(2)
        assertThat(winners).contains("clover", "lini")
    }

    @DisplayName("우승자가 1명일 때, 한 명만 우승자로 반환되어야 한다.")
    @Test
    fun findWinners_singleWinner() {
        val singleWinnerCars = listOf(
            Car("eden", 3),
            Car("clover", 4),
            Car("lini", 2)
        )
        val singleWinnerScores = CarScores(singleWinnerCars)
        val winners = singleWinnerScores.findWinners()

        assertThat(winners).hasSize(1)
        assertThat(winners).contains("clover")
    }

    @DisplayName("각 자동차의 점수를 확인할 때, 자동차 이름에 맞는 점수가 반환되어야 한다.")
    @Test
    fun getScores() {
        val scores = carScores.getScores()
        assertThat(scores["eden"]).isEqualTo(3)
        assertThat(scores["clover"]).isEqualTo(5)
        assertThat(scores["lini"]).isEqualTo(5)
    }
}
