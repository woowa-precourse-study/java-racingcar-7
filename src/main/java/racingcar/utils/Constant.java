package racingcar.utils;

public class Constant {
  public final static String REQUIRE_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  public final static String REQUIRE_TRY_NUMBER = "시도할 회수는 몇회인가요?";
  public final static String CAR_NAME_ERROR = "차량 이름 양식 오류";
  public final static String TRY_NUMBER_ERROR = "시도 회수 양식 오류";
  public final static String REGEX_CAR_NAME = "^[a-z]{1,5}$";
  public final static String REGEX_TRY_NUMBER = "^[0-9]$";
}
