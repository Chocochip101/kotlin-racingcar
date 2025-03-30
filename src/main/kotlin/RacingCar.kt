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
        outputView.promptForCarNames()
        val carNames = inputView.readCarNames()
        outputView.promptForRaceCount()
        val attemptCount = inputView.readAttemptCount()

        val cars = carNames.map { Car(it) }
        val game = RacingGame(cars, RandomNumberGenerator())

        repeat(attemptCount) {
            game.play()
            val scores = CarScores(cars)
            outputView.printScores(scores.getScores())
        }

        val scores = CarScores(cars)
        outputView.printWinners(scores.findWinners())
    }
}
