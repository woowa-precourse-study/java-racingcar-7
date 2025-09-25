package racingcar.util;

public class Split {

    private static final String DELIMITER = ",";

    public static String[] split(String str) {
        return str.split(DELIMITER);
    }
}
