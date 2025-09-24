package racingcar.controller;


import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;
import racingcar.utils.constant.Message;

public class RaceController {

  public String[] inputCarNames() {
    System.out.println(Message.REQUIRE_CAR_NAMES);
    String[] cars = Console.readLine().split(",");
    Validator.validateCarName(cars);
    return cars;
  }

  public int inputTryNumber() {
    System.out.println(Message.REQUIRE_TRY_NUMBER);
    String tryNumber = Console.readLine();
    Validator.validateTryNumber(tryNumber);
    return Integer.parseInt(tryNumber);
  }
}
