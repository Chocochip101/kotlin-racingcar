package racinggame

import fixture.CarFixture
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldContain
import io.kotest.matchers.shouldBe

class CarScoresTest : StringSpec({

    "우승자가 2명일 때, 두 명이 우승자로 반환되어야 한다." {
        val car1 = CarFixture.edenCar
        val car2 = CarFixture.liniCar
        val car3 = CarFixture.cloveCar
        car1.move()
        car2.move()
        val cars = listOf(car1, car2, car3)
        val carScores = CarScores(cars)

        val winners = carScores.findWinners()

        winners.shouldHaveSize(2)
        winners.shouldContainAll(car1.getName(), car2.getName())
    }

    "우승자가 1명일 때, 한 명만 우승자로 반환되어야 한다." {
        val car1 = CarFixture.edenCar
        val car2 = CarFixture.liniCar
        val car3 = CarFixture.cloveCar
        car1.move()
        val singleWinnerCars = listOf(car1, car2, car3)
        val singleWinnerScores = CarScores(singleWinnerCars)

        val winners = singleWinnerScores.findWinners()

        winners.shouldHaveSize(1)
        winners[0] shouldBe car1.getName()
    }

    "각 자동차의 점수를 확인할 때, 자동차 이름에 맞는 점수가 반환되어야 한다." {
        val car1 = CarFixture.edenCar
        val car2 = CarFixture.liniCar
        val car3 = CarFixture.cloveCar
        car3.move()
        val cars = listOf(car1, car2, car3)
        val carScores = CarScores(cars)
        val scores = carScores.getScores()

        scores.shouldContain(car1.getName() to 0)
        scores.shouldContain(car2.getName() to 0)
        scores.shouldContain(car3.getName() to 1)
    }

    "자동차가 없을 때, findWinners는 예외를 던져야 한다." {
        val emptyCarScores = CarScores(emptyList())

        shouldThrow<NoSuchElementException> {
            emptyCarScores.findWinners()
        }
    }
})
