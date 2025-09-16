package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.console.InputConsole;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현

    // Console 부분
    InputConsole input = new InputConsole();
    String[] cars = input.inputCarNames();
    int tryNumberInt = input.inputTryNumber();

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
