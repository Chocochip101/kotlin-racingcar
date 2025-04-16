package racinggame

import fixture.CarFixture
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeZero
import io.kotest.matchers.shouldBe
import racinggame.numberGeneratorImpl.FakeNumberGenerator

class RacingGameTest : StringSpec({

    lateinit var cars: List<Car>

    beforeTest {
        cars = listOf(CarFixture.edenCar, CarFixture.liniCar, CarFixture.cloveCar)
    }

    "랜덤 값이 4 이상이면 자동차가 전진해야 한다." {
        val alwaysMoveGenerator = FakeNumberGenerator(4)
        val racingGame = RacingGame(cars, alwaysMoveGenerator)

        racingGame.play()

        cars.forEach { car ->
            car.distance shouldBe 1
        }
    }

    "랜덤 값이 3 이하이면 자동차가 멈춰야 한다." {
        val neverMoveGenerator = FakeNumberGenerator(3)
        val racingGame = RacingGame(cars, neverMoveGenerator)

        racingGame.play()

        cars.forEach { car ->
            car.distance.shouldBeZero()
        }
    }
})
