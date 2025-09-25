package racingcar.util;

import java.util.List;
import java.util.stream.Stream;

import static racingcar.constant.ErrorMessage.*;

public class Validator {

    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ONLY_WHITESPACE_ERROR.getErrorMessage());
        }
    }

    public static void validateLength(String[] splitCarNames) {
        List<String> carNames = Stream.of(splitCarNames)
                .filter(s -> !s.isBlank())
                .filter(s -> s.length() > 5)
                .toList();
        if (!carNames.isEmpty()) {
            throw new IllegalArgumentException(MAXIMUM_LENGTH_ERROR.getErrorMessage());
        }
    }

    public static void validateOverflow(String inputRaceCount, int raceCount) {
        if (!inputRaceCount.equals(String.valueOf(raceCount))) {
            throw new IllegalArgumentException(INTEGER_OVERFLOW_ERROR.getErrorMessage());
        }
    }
}
