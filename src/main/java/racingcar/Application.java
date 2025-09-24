package racingcar;

import java.util.List;
import racingcar.controller.RaceController;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.service.RaceService;
import racingcar.view.RaceView;

public class Application {

  public static void main(String[] args) {

    RaceController raceController = new RaceController();
    String[] carNames = raceController.inputCarNames();
    int tryNumberInt = raceController.inputTryNumber();

    RaceService raceService = new RaceService();

    Cars cars = new Cars(carNames);
    raceService.startRace(tryNumberInt, cars);

    List<String> winners = Race.findWinner(cars);
    RaceView raceView = new RaceView();
    raceView.printWinner(winners);
  }

}
