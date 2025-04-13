package racinggame

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {
    private lateinit var car: Car
    private val carName = "eden"

    @BeforeEach
    fun setUp() {
        car = Car(carName)
    }

    @DisplayName("자동차가 움직일 경우, 거리가 1 증가해야 한다.")
    @Test
    fun move() {
        car.move()
        assertThat(car.distance).isEqualTo(1)
    }

    @DisplayName("자동차의 이름을 정상적으로 반환해야 한다.")
    @Test
    fun getName() {
        assertThat(car.getName()).isEqualTo(carName)
    }

    @DisplayName("자동차의 초기 거리는 0이어야 한다.")
    @Test
    fun getDistance() {
        assertThat(car.distance).isZero()
    }
}
