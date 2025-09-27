package racingcar.constant;

public enum ErrorMessage {
    // 에러 메시지 통합 관리
    NO_CAR_ERROR("No cars exist."),
    NOT_POSITIVE_NUMBER_ERROR("Enter a positive number."),
    ONLY_WHITESPACE_ERROR("Input contains only whitespace."),
    MAXIMUM_LENGTH_ERROR("Maximum length of the car name is 5 characters."),
    INTEGER_OVERFLOW_ERROR("The input count causes an integer overflow.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = "[Invalid input] " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
