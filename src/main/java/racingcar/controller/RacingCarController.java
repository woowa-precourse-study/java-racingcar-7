package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView = new InputView();
    private final RacingCarService racingCarService = new RacingCarService();
    private final ResultView resultView = new ResultView();

    public void run(){
        String rawCarNames = inputView.readCarNames();
        int rawRound = inputView.readRound(); // 변수명 일관성

        List<List<Car>> raceHistory = racingCarService.startRace(rawCarNames, rawRound);
        resultView.printRaceHistory(raceHistory);

        List<Car> winners = racingCarService.getWinners(raceHistory); // raceHistory 객체라니 진짜 짱이다
        resultView.printWinners(winners);
    }
}
