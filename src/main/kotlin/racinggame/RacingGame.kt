package racinggame

class RacingGame(private val cars: List<Car>, private val numberGenerator: NumberGenerator) {

    companion object {
        const val MOVE_THRESHOLD = 4
    }

    fun play() {
        cars.forEach { car ->
            if (numberGenerator.generate() >= MOVE_THRESHOLD) {
                car.move()
            }
        }
    }
}
