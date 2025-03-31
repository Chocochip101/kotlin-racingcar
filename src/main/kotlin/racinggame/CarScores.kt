package racinggame

class CarScores(cars: List<Car>) {
    private val scores = mutableMapOf<String, Int>()

    init {
        cars.forEach { scores[it.getName()] = it.getDistance() }
    }

    fun findWinners(): List<String> {
        val maxScore = scores.values.maxOrNull() ?: return emptyList()
        return scores.filter { it.value == maxScore }.keys.toList()
    }

    fun getScores(): Map<String, Int> = scores
}
