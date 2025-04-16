package racinggame

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeZero
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    val carName = "eden"
    lateinit var car: Car

    beforeTest {
        car = Car(carName)
    }

    "자동차가 움직일 경우, 거리가 1 증가해야 한다." {
        car.move()
        car.distance shouldBe 1
    }

    "자동차의 이름을 정상적으로 반환해야 한다." {
        car.getName() shouldBe carName
    }

    "자동차의 초기 거리는 0이어야 한다." {
        car.distance.shouldBeZero()
    }
})
