package racingcar.util;

import java.util.List;
import java.util.stream.Stream;

public class Validator {

    public static void validateNull(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLength(String[] splitCarNames) {
        List<String> carNames = Stream.of(splitCarNames)
                .filter(s -> !s.isBlank())
                .filter(s -> s.length() > 5)
                .toList();
        if (!carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateOverflow(String inputRaceCount) {
        if (inputRaceCount.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException();
        }
    }
}
