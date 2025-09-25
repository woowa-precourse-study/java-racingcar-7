package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final RacingService service;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(RacingService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String inputCarNames = inputView.readCarNames();
        String inputRaceCount = inputView.readRaceCount();

        Cars cars = service.getCars(inputCarNames);
        int raceCount = service.getRaceCount(inputRaceCount);
        service.runRace(cars, raceCount);
        String winners = service.decideWinners(cars);

        outputView.printRace(cars, raceCount);
        outputView.printWinners(winners);
    }
}
