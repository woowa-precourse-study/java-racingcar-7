package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class RaceView {

  public static void printProgress(Car[] carArray) {
    for (Car car : carArray) {
      System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
    }
    System.out.println();
  }

  public void printWinner(List<String> winners) {
    System.out.println("최종 우승자 : " + String.join(", ", winners));
  }
}
