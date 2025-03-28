import view.OutputView

class RacingCar {
    private val outputView = OutputView()

    fun run() {
        outputView.promptForCarNames()
    }
}
