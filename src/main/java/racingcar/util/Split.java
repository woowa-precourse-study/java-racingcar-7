package racingcar.util;

import java.util.List;
import java.util.stream.Stream;

public class Split {

    private static final String DELIMITER = ",";

    public static List<String> split(String str) {
        return Stream.of(str.split(DELIMITER)).map(String::strip).toList();
    }
}
