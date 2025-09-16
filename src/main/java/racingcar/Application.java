package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import racingcar.utils.Constant;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현

    // Console 부분
    System.out.println(Constant.REQUIRE_CAR_NAMES);
    String[] cars = Console.readLine().split(",");
    for (String car : cars) {
      if (!Pattern.matches(Constant.REGEX_CAR_NAME, car)) {
        throw new IllegalArgumentException(Constant.CAR_NAME_ERROR);
      }
    }
    System.out.println(Constant.REQUIRE_TRY_NUMBER);
    String tryNumber = Console.readLine();
    if (!Pattern.matches(Constant.REGEX_TRY_NUMBER, tryNumber)) {
      throw new IllegalArgumentException(Constant.TRY_NUMBER_ERROR);
    }
    int tryNumberInt = Integer.parseInt(tryNumber);

    //moveCar 부분
    HashMap<String,Integer> carInfo = new HashMap<>();
    for(String car : cars){
      carInfo.put(car,0);
    }
    while(tryNumberInt > 0) {
      for(String car : cars){
        int currentPosition = carInfo.get(car);
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if(randomNumber >=4) {
          currentPosition++;
          carInfo.put(car,currentPosition);
        }
        System.out.println(car + " : " +  "-".repeat(currentPosition));
      }
      System.out.println();
      tryNumberInt--;
    }
    // 우승자 출력
    int maxDistance = carInfo.values()
            .stream()
            .max(Integer::compareTo)
            .orElse(0); // 최댓값 구하기

    List<String> winners = carInfo.entrySet()
            .stream()
            .filter(entry -> entry.getValue() == maxDistance) // 최댓값과 같은 차량 필터링
            .map(Map.Entry::getKey) // 차량 이름만 추출
            .toList();
    System.out.println("우승자 : " + String.join(",", winners));
  }

}
