package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.RaceView;

public class RaceService {

  public void startRace(int tryNumber, Cars cars) {
    Race race = new Race();
    Car[] carArray = cars.getCars();
    while (tryNumber > 0) {
      race.moveCar(carArray);
      RaceView.printProgress(carArray);
      tryNumber--;
    }
  }
}
