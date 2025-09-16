package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현

    // Console 부분
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String[] cars = Console.readLine().split(",");
    for (String car : cars) {
      if (!Pattern.matches("^[a-z]{1,5}$", car)) {
        throw new IllegalArgumentException("차량 이름 양식 오류");
      }
    }
    System.out.println("시도할 회수는 몇회인가요?");
    //int tryNumber = Integer.parseInt(Console.readLine());
    String tryNumber = Console.readLine();
    if (!Pattern.matches("[0-9]$", tryNumber)) {
      throw new IllegalArgumentException("시도 회수 양식 오류");
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
