package racingcar.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Constant;
import racingcar.utils.Validators;

public class InputConsole {
  public String[] inputCarNames(){
    System.out.println(Constant.REQUIRE_CAR_NAMES);
    String[] cars = Console.readLine().split(",");
    Validators.validateCarName(cars);
    return cars;
  }

  public int inputTryNumber(){
    System.out.println(Constant.REQUIRE_TRY_NUMBER);
    String tryNumber = Console.readLine();
    Validators.validateTryNumber(tryNumber);
    return Integer.parseInt(tryNumber);
  }
}
