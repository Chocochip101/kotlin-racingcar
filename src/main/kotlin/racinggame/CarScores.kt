package racinggame

class CarScores(cars: List<Car>) {
    private val scores: Map<String, Int> = cars.associate { it.getName() to it.distance }

    fun findWinners(): List<String> {
        val maxScore = scores.values.max()
        return scores.filter { it.value == maxScore }.keys.toList()
    }

    fun getScores(): Map<String, Int> = scores
}
