package racinggame

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarNameTest : StringSpec({

    "차 이름이 5글자 이하일 경우, 정상적으로 생성되어야 한다." {
        val carName = CarName("eden")
        carName.value shouldBe "eden"
    }

    "차 이름이 6글자 이상일 경우, 예외가 발생해야 한다." {
        val exception =
            shouldThrow<IllegalArgumentException> {
                CarName("eden_babo")
            }
        exception.message shouldBe "자동차 이름은 5 글자 이하이어야 합니다."
    }
})
