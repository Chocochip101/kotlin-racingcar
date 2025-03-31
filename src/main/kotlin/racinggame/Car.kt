package racinggame


class Car(private val name: CarName, private var distance: Int = 0) {

    constructor(name: String) : this(CarName(name))

    fun move() {
        distance++
    }

    fun getName(): String = name.getName()

    fun getDistance(): Int = distance
}
