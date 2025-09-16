package racingcar.console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultConsole {

  public int getMaxDistance(HashMap<String, Integer> carInfo) {
    return carInfo.values().stream().max(Integer::compareTo).orElse(0); // 최댓값 구하기
  }

  public void printResult(HashMap<String, Integer> carInfo, int maxDistance) {
    List<String> winners = carInfo.entrySet()
            .stream()
            .filter(entry -> entry.getValue() == maxDistance) // 최댓값과 같은 차량 필터링
            .map(Map.Entry::getKey) // 차량 이름만 추출
            .toList();
    System.out.println("최종 우승자 : " + String.join(",", winners));
  }
}
