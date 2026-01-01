package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.Validator;

import java.util.List;
import java.util.NoSuchElementException;

public class InputView {

    public String readMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readInput(List.of(
                Validator::validateNotBlank,
                Validator::validateNameIsUnique
        ));
        return input;
    }

    public int readTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readInput(List.of(
                Validator::validateNotBlank,
                Validator::validatePositiveNumber
        ));
        return Integer.parseInt(input);
    }



    private String readInput(List<Validator> validators) {
        try{
            String input = Console.readLine().trim();
            for (Validator v : validators) {
                v.validate(input);
            }
            return input;
        } catch(NoSuchElementException e){
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }

    }
}
