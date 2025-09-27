package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    private final InputView inputView = new InputView();
    private final RacingCarService racingCarService = new RacingCarService();
    private final ResultView resultView = new ResultView();

    public void run(){
        resultView.printResult(racingCarService.startRace(inputView.readCarNames(), inputView.readRound()));
    }
}
