package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.domain.Result;
import racingcar.service.Service;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final Service service;

    public Controller(Service service) {
        this.inputView = new InputView();
        this.service = service;
    }

    public void run() {
        CarGroup carGroup = new CarGroup();
        List<String> inputs = inputView.readCars();

        for (String input:inputs){
            carGroup.add(new Car(input));
        }

        int number = inputView.readNumber();
        for (int i = 0; i<number;i++){
            carGroup.playGame();
        }

        OutputView.printResult(carGroup.getResults());

    }



}

