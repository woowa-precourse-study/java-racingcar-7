package racingcar.utils;

import java.util.regex.Pattern;
import racingcar.utils.constant.Constant;
import racingcar.utils.constant.Message;
import racingcar.utils.constant.Regex;

public class Validator {
  private Validator() {}

  public static void validateCarName(String[] cars) {
    for (String car : cars) {
      if (!Pattern.matches(Regex.CAR_NAME, car)) {
        throw new IllegalArgumentException(Message.ERROR_CAR_NAME);
      }
    }
  }

  public static void validateTryNumber(String tryNumber) {
    if (!Pattern.matches(Regex.TRY_NUMBER, tryNumber)) {
      throw new IllegalArgumentException(Message.ERROR_TRY_NUMBER);
    }
  }

}
