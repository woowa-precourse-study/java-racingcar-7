package racingcar.util;

import static racingcar.constant.ErrorMessage.*;

public class ParseInt {

    public static int parseInt(String str) {
        int integer;
        try {
            integer = Integer.parseUnsignedInt(str); // 문자열을 양수로 변환
        } catch (NumberFormatException e) {
            // 문자열을 양수로 변환할 수 없으면 예외 발생(예. 음수이거나 숫자가 아닌 문자가 포함된 경우)
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR.getErrorMessage());
        }
        return integer;
    }
}
