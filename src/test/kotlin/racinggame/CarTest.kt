package racinggame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {


    @DisplayName("자동차가 움직일 경우, 거리가 1 증가해야 한다.")
    @Test
    fun move() {
        val car = Car("pobi")
        car.move()
        assertEquals(1, car.distance, "자동차가 한 칸 이동해야 합니다.")
    }

    @DisplayName("자동차의 이름을 정상적으로 반환해야 한다.")
    @Test
    fun getName() {
        val car = Car("crong")
        assertEquals("crong", car.name, "자동차 이름이 올바르게 저장되지 않았습니다.")
    }

    @DisplayName("자동차의 초기 거리는 0이어야 한다.")
    @Test
    fun getDistance() {
        val car = Car("honux")
        assertEquals(0, car.distance, "자동차의 초기 위치가 0이 아닙니다.")
    }
}
