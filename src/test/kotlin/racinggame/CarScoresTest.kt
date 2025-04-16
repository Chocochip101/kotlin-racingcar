package racinggame

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarScoresTest {
    private lateinit var carScores: CarScores
    private lateinit var cars: List<Car>
    private val name1 = CarName("eden")
    private val name2 = CarName("clove")
    private val name3 = CarName("lini")

    @BeforeEach
    fun setUp() {
        cars =
            listOf(
                Car(name1, 3),
                Car(name2, 5),
                Car(name3, 5),
            )
        carScores = CarScores(cars)
    }

    @DisplayName("우승자가 2명일 때, 두 명이 우승자로 반환되어야 한다.")
    @Test
    fun findWinners() {
        val winners = carScores.findWinners()
        assertThat(winners).hasSize(2)
        assertThat(winners).contains(name2.value, name3.value)
    }

    @DisplayName("우승자가 1명일 때, 한 명만 우승자로 반환되어야 한다.")
    @Test
    fun findWinners_singleWinner() {
        val singleWinnerCars =
            listOf(
                Car(name1, 3),
                Car(name2, 4),
                Car(name3, 2),
            )
        val singleWinnerScores = CarScores(singleWinnerCars)
        val winners = singleWinnerScores.findWinners()

        assertThat(winners).hasSize(1)
        assertThat(winners).contains(name2.value)
    }

    @DisplayName("각 자동차의 점수를 확인할 때, 자동차 이름에 맞는 점수가 반환되어야 한다.")
    @Test
    fun getScores() {
        val scores = carScores.getScores()
        assertThat(scores[name1.value]).isEqualTo(3)
        assertThat(scores[name2.value]).isEqualTo(5)
        assertThat(scores[name3.value]).isEqualTo(5)
    }

    @DisplayName("자동차가 없을 때, findWinners는 예외를 던져야 한다.")
    @Test
    fun findWinners_throwsExceptionWhenNoCars() {
        val emptyCarScores = CarScores(emptyList())

        assertThrows<NoSuchElementException> {
            emptyCarScores.findWinners()
        }
    }

}
