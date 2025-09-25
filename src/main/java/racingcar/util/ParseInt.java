package racingcar.util;

public class ParseInt {

    public static int parseInt(String str) {
        int integer;
        try {
            integer = Integer.parseUnsignedInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return integer;
    }
}
