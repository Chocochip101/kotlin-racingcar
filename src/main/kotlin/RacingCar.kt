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
    }
}
