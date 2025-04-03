package racinggame

class RacingGame(private val cars: List<Car>, private val numberGenerator: NumberGenerator) {

    fun play() {
        cars.forEach { car ->
            moveCar(car)
        }
    }

    private fun moveCar(car: Car) {
        if (numberGenerator.generate() >= MOVE_THRESHOLD) {
            car.move()
        }
    }

    companion object {
        const val MOVE_THRESHOLD = 4
    }
}
