package racinggame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarNameTest {

    @DisplayName("차 이름이 5글자 이하일 경우, 정상적으로 생성되어야 한다.")
    @Test
    fun shouldCreateCarNameSuccessfully_WhenNameIsValid() {
        val carName = CarName("pobi")
        assertEquals("pobi", carName.getName(), "자동차 이름이 올바르게 저장되지 않았습니다.")
    }

    @DisplayName("차 이름이 6글자 이상일 경우, 예외가 발생해야 한다.")
    @Test
    fun shouldThrowException_WhenNameIsTooShort() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            CarName("pobiiiii")
        }
        assertEquals("자동차 이름은 5글자 이하이어야 합니다.", exception.message)
    }
}
