package racingcar.util;

import static racingcar.constant.ErrorMessage.*;

public class ParseInt {

    public static int parseInt(String str) {
        int integer;
        try {
            integer = Integer.parseUnsignedInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR.getErrorMessage());
        }
        return integer;
    }
}
