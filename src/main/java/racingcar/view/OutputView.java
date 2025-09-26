package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printRace(Cars cars, int raceCount) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < raceCount; i++) {
            System.out.println(cars.getRace(i)); // 매 라운드 진행 과정 출력
        }
    }

    public void printWinners(String winners) {
        System.out.println(WINNERS_MESSAGE + winners);
    }
}