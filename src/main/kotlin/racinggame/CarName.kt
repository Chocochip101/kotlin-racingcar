package racinggame

data class CarName(val value: String) {
    init {
        require(value.length <= CAR_NAME_LIMIT) { ERROR_MESSAGE }
    }

    companion object {
        const val CAR_NAME_LIMIT = 5
        const val ERROR_MESSAGE = "자동차 이름은 $CAR_NAME_LIMIT 글자 이하이어야 합니다."
    }
}
