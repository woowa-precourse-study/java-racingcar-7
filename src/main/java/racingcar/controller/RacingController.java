package racingcar.controller;

import racingcar.exception.Validator;
import racingcar.service.RacingService;
import racingcar.utils.Parser;

import java.util.List;
import java.util.function.Supplier;

public class RacingController {
    private final InputView inputView;
    private final RacingService service;
    static final int MAX_RETRY = 10;

    public RacingController(RacingService service) {
        this.inputView = new InputView();
        this.service = service;
    }

    public void run() {
        String input = inputView.readMessage();
        List<String> names= Parser.splitBy(input,",");

        for (String name:names){
            Validator.validateMaxLength(name);
        }

        int tryNumber = inputView.readTryNumber();






    }



}

