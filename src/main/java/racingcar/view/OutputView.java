package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printRace(Cars cars, int raceCount) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < raceCount; i++) {
            System.out.println(cars.getRace(i));
        }
    }

    public void printWinners(String winners) {
        System.out.println(WINNERS_MESSAGE + winners);
    }
}
