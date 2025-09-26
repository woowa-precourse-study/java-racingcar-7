package racingcar.util;

import java.util.List;

import static racingcar.constant.Constant.NAME_MAX_LENGTH;
import static racingcar.constant.ErrorMessage.*;

public class Validator {

    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ONLY_WHITESPACE_ERROR.getErrorMessage());
        }
    }

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

    public static void validateNoCars(List<String> splitCarNames) {
        List<String> carNames = splitCarNames
                .stream()
                .filter(s -> !s.isBlank())
                .toList();
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(NO_CAR_ERROR.getErrorMessage());
        }
    }

    public static void validateOverflow(String inputRaceCount, int raceCount) {
        if (!inputRaceCount.equals(String.valueOf(raceCount))) {
            throw new IllegalArgumentException(INTEGER_OVERFLOW_ERROR.getErrorMessage());
        }
    }
}
