package racingcar.controller;


import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;
import racingcar.utils.constant.Message;

public class RaceController {

  public String[] inputCarNames() {
    System.out.println(Message.REQUIRE_CAR_NAMES);
    String[] input = Console.readLine().split(",");
    String[] cars = new String[input.length];
    for(int i = 0 ; i < input.length ; i++) {
      cars[i] = input[i].trim();
    }
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
