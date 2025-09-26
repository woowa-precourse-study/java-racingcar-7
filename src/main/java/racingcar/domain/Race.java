package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Race {

  public void moveCar(Car[] carArray) {
    for (Car car : carArray) {
      int randomNumber = Randoms.pickNumberInRange(0, 9);
      if (randomNumber >= 4) {
        car.updateDistance();
      }
    }
  }

  public static List<String> findWinner(Cars cars) {
    Car[] carArray = cars.getCars();
    Arrays.sort(carArray, Comparator.comparingInt(Car::getDistance).reversed());

    List<String> winnerNames = new ArrayList<>();
    int maxDistance = carArray[0].getDistance();
    for (Car car : carArray) {
      if (car.getDistance() == maxDistance) {
        winnerNames.add(car.getName());
      }
    }
    return winnerNames;
  }
}
