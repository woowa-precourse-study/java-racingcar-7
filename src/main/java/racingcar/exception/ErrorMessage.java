package racingcar.exception;

public class ErrorMessage {

    private ErrorMessage(){};

    public static final String EMPTY_STRING="문자열이 입력되지 않았습니다.";
    public static final String TOO_LONG_CAR_NAME="5글자 이하의 자동차 이름을 입력해주세요";
    public static final String SAME_CAR_NAME="동일한 자동차 이름은 허용하지 않습니다.";
    public static final String INVALID_TRY="올바르지 않은 입력 형식입니다. 숫자를 입력해주세요";
    public static final String TOO_MANY_TRY_COUNT="0이상 9 이하의 값을 입력해주세요";

}
