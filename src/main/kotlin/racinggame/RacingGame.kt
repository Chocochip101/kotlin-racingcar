package racinggame

class RacingGame(private val cars: List<Car>) {

    fun play() {
        cars.forEach { car ->
            if ((0..9).random() >= 4) {
                car.move()
            }
        }
    }
}
