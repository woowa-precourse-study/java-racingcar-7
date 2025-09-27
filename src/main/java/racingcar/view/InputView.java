package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CARNAMES_INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MSG = "시도할 회수는 몇회인가요?";

    public String readCarNames() {
        System.out.println(CARNAMES_INPUT_MSG);
        return Console.readLine().strip();
    }

    public int readRound(){
        System.out.println(ROUND_INPUT_MSG);
        String roundString = Console.readLine().strip();

        try {
            return Integer.parseInt(roundString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }

    }
}
