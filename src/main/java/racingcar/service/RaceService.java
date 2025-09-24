package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RaceService {

  public boolean moveCar() {
    int randomNumber = Randoms.pickNumberInRange(0, 9);
    if (randomNumber >= 4) {
      return true;
    } else {
      return false;
    }
  }

  public void startRace(int tryNumber, Cars cars) {
    Car[] carArray = cars.getCars();
    while (tryNumber > 0) {
      for (Car car : carArray) {
        if (moveCar()) {
          car.updateDistance();
        }
        System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
      }
      System.out.println();
      tryNumber--;
    }
  }

  public List<String> findWinner(Cars cars) {
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
