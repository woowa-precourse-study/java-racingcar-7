package racingcar.utils;

import java.util.regex.Pattern;

public class Validators {
  private Validators() {}

  public static void validateCarName(String[] cars) {
    for (String car : cars) {
      if (!Pattern.matches(Constant.REGEX_CAR_NAME, car)) {
        throw new IllegalArgumentException(Constant.CAR_NAME_ERROR);
      }
    }
  }

  public static void validateTryNumber(String tryNumber) {
    if (!Pattern.matches(Constant.REGEX_TRY_NUMBER, tryNumber)) {
      throw new IllegalArgumentException(Constant.TRY_NUMBER_ERROR);
    }
  }
}
