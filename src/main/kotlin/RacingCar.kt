import racinggame.Car
import racinggame.CarScores
import racinggame.RacingGame
import racinggame.numberGeneratorImpl.RandomNumberGenerator
import view.InputView
import view.OutputView

class RacingCar {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        val carNames = readCarNames()
        val attemptCount = readAttemptCount()

        val cars = carNames.map { Car(it) }
        val game = RacingGame(cars, RandomNumberGenerator())

        processGame(attemptCount, game, cars)
        printWinners(cars)
    }

    private fun readCarNames(): List<String> {
        outputView.promptForCarNames()
        return inputView.readCarNames()
    }

    private fun readAttemptCount(): Int {
        outputView.promptForRaceCount()
        return inputView.readAttemptCount()
    }
    
    private fun processGame(
        attemptCount: Int,
        game: RacingGame,
        cars: List<Car>
    ) {
        repeat(attemptCount) {
            game.play()
            val scores = CarScores(cars)
            outputView.printScores(scores.getScores())
        }
    }

    private fun printWinners(cars: List<Car>) {
        val scores = CarScores(cars)
        outputView.printWinners(scores.findWinners())
    }
}
