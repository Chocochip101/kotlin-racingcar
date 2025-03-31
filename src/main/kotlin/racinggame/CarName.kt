package racinggame

class CarName(private val value: String) {

    init {
        require(value.length <= 5) { "자동차 이름은 5글자 이하이어야 합니다." }
    }

    fun getName(): String = value
}
