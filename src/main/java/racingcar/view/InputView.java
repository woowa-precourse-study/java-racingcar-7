package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

import static racingcar.constant.ErrorMessage.ONLY_WHITESPACE_ERROR;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String readCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        try {
            return Console.readLine().strip();
        } catch (NoSuchElementException e) {
            // Console이 입력을 못 받는 상황을 IllegalArgumentException 으로 통일
            throw new IllegalArgumentException(ONLY_WHITESPACE_ERROR.getErrorMessage());
        }
    }

    public String readRaceCount() {
        System.out.println(NUMBER_INPUT_MESSAGE);
        try {
            return Console.readLine().strip();
        } catch (NoSuchElementException e) {
            // Console이 입력을 못 받는 상황을 IllegalArgumentException 으로 통일
            throw new IllegalArgumentException(ONLY_WHITESPACE_ERROR.getErrorMessage());
        }
    }
}
