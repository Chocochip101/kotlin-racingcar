import racinggame.Car
import racinggame.CarScores
import racinggame.RacingGame
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

        repeat(attemptCount) {
            val game = RacingGame(cars)
            game.play()
            val scores = CarScores(cars)
            outputView.printScores(scores.getScores())
        }

        val scores = CarScores(cars)
        outputView.printWinners(scores.findWinners())
    }
}
