package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.console.InputConsole;
import racingcar.console.ResultConsole;
import racingcar.race.Race;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현

    // Console 부분
    InputConsole input = new InputConsole();
    String[] cars = input.inputCarNames();
    int tryNumberInt = input.inputTryNumber();

    //Race 부분
    Race race = new Race();
    HashMap<String,Integer> carInfo = race.setCarInfo(cars);
    race.startRace(tryNumberInt,cars,carInfo);

    // 우승자 출력
    ResultConsole resultConsole = new ResultConsole();
    int maxDistance = resultConsole.getMaxDistance(carInfo);
    resultConsole.printResult(carInfo,maxDistance);
  }

}
