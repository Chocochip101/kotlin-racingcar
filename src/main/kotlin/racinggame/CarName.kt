package racinggame

class CarName(private val value: String) {

    companion object {
        const val CAR_NAME_LIMIT = 5
        const val ERROR_MESSAGE = "자동차 이름은 $CAR_NAME_LIMIT 글자 이하이어야 합니다."
    }

    init {
        require(value.length <= CAR_NAME_LIMIT) { ERROR_MESSAGE }
    }

    fun getName(): String = value
}
