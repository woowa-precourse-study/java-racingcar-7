package racingcar.controller;

import racingcar.domain.Car;
import racingcar.exception.Validator;
import racingcar.service.RacingService;
import racingcar.utils.Parser;
import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
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

        List<Car> cars = new ArrayList<>();
        for (String name:names){
            cars.add(new Car(name));
        }

        int tryNumber = inputView.readTryNumber();
        OutputView.printResult();

        for (int i=0;i<tryNumber;i++){
            for (Car car:cars){
                car.movePosition(RandomGenerator.getRandomNumber()>=4);
            }
            OutputView.printRoundResult(cars);
        }




    }



}

