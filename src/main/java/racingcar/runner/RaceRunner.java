package racingcar.runner;

import java.util.List;
import racingcar.controller.RaceController;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.service.RaceService;
import racingcar.view.RaceView;

public class RaceRunner {

  public void run() {
    RaceController raceController = new RaceController();
    String[] carNames = raceController.inputCarNames();
    int tryNumber = raceController.inputTryNumber();

    RaceService raceService = new RaceService();

    Cars cars = new Cars(carNames);
    raceService.startRace(tryNumber, cars);

    List<String> winners = Race.findWinner(cars);
    RaceView raceView = new RaceView();
    raceView.printWinner(winners);
  }
}
