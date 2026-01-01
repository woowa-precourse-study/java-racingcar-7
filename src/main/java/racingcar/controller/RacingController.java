package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.utils.Parser;
import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final RacingService service;

    public RacingController(RacingService service) {
        this.inputView = new InputView();
        this.service = service;
    }

    public void run() {
        String input = inputView.readMessage();
        List<String> names=Parser.splitBy(input,",");
        List<Car> cars = service.enrollCars(names);

        int tryNumber = inputView.readTryNumber();
        OutputView.printResult();

        for (int i=0;i<tryNumber;i++){
            service.moveCars(cars);
            OutputView.printRoundResult(cars);
        }

        List<String> winners = service.getWinners(cars);
        OutputView.printWinnerResult(winners);

    }



}

