package racinggame

class RacingGame(private val cars: List<Car>, private val numberGenerator: NumberGenerator) {

    fun play() {
        cars.forEach { car ->
            if (numberGenerator.generate() >= 4) {
                car.move()
            }
        }
    }
}
