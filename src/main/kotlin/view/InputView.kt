package view

private const val NAME_DELIMITER = ","

class InputView {

    fun readCarNames(): List<String> {
        val input = readlnOrNull() ?: throw IllegalArgumentException("자동차 이름을 입력해주세요.")
        return input.split(NAME_DELIMITER).map { it.trim() }
    }

    fun readAttemptCount(): Int {
        val input = readlnOrNull() ?: throw IllegalArgumentException("시도횟수를 입력해주세요.")
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("정수를 입력해주세요.")
        return number
    }
}
