package racingcar.util;

import java.util.List;

import static racingcar.constant.Constant.NAME_MAX_LENGTH;
import static racingcar.constant.ErrorMessage.*;

public class Validator {

    // 입력값이 빈 문자열이 아닌지 검증
    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ONLY_WHITESPACE_ERROR.getErrorMessage());
        }
    }

    // 각 자동차 이름의 길이가 5를 초과하지 않는지 검증
    public static void validateLength(List<String> splitCarNames) {
        List<String> carNames = splitCarNames
                .stream()
                .filter(s -> !s.isBlank())
                .filter(s -> s.strip().length() > NAME_MAX_LENGTH)
                .toList();
        if (!carNames.isEmpty()) {
            throw new IllegalArgumentException(MAXIMUM_LENGTH_ERROR.getErrorMessage());
        }
    }

    // 유효한 자동차 이름이 1개 이상인지 검증
    public static void validateNoCars(List<String> splitCarNames) {
        List<String> carNames = splitCarNames
                .stream()
                .filter(s -> !s.isBlank())
                .toList();
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(NO_CAR_ERROR.getErrorMessage());
        }
    }

    // 정수 오버플로우 검증
    public static void validateOverflow(String inputRaceCount, int raceCount) {
        // '양수로 변환한 값 != 입력 문자열'이면 오버플로우로 간주
        if (!inputRaceCount.equals(String.valueOf(raceCount))) {
            throw new IllegalArgumentException(INTEGER_OVERFLOW_ERROR.getErrorMessage());
        }
    }
}
