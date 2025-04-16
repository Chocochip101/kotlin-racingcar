package racinggame

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldContain
import io.kotest.matchers.shouldBe

class CarScoresTest : StringSpec({

    val name1 = CarName("eden")
    val name2 = CarName("clove")
    val name3 = CarName("lini")

    lateinit var cars: List<Car>
    lateinit var carScores: CarScores

    beforeTest {
        cars =
            listOf(
                Car(name1, 3),
                Car(name2, 5),
                Car(name3, 5),
            )
        carScores = CarScores(cars)
    }

    "우승자가 2명일 때, 두 명이 우승자로 반환되어야 한다." {
        val winners = carScores.findWinners()

        winners.shouldHaveSize(2)
        winners.shouldContainAll(name2.value, name3.value)
    }

    "우승자가 1명일 때, 한 명만 우승자로 반환되어야 한다." {
        val singleWinnerCars =
            listOf(
                Car(name1, 3),
                Car(name2, 4),
                Car(name3, 2),
            )
        val singleWinnerScores = CarScores(singleWinnerCars)

        val winners = singleWinnerScores.findWinners()

        winners.shouldHaveSize(1)
        winners[0] shouldBe name2.value
    }

    "각 자동차의 점수를 확인할 때, 자동차 이름에 맞는 점수가 반환되어야 한다." {
        val scores = carScores.getScores()

        scores.shouldContain(name1.value to 3)
        scores.shouldContain(name2.value to 5)
        scores.shouldContain(name3.value to 5)
    }

    "자동차가 없을 때, findWinners는 예외를 던져야 한다." {
        val emptyCarScores = CarScores(emptyList())

        shouldThrow<NoSuchElementException> {
            emptyCarScores.findWinners()
        }
    }
})
