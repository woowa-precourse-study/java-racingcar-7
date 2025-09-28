package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    private static final String RESULT_MSG = "최종 우승자 : ";
    
    // stringbuilder 쓰면 시간 개선할 수 있을텐데
    public void printRaceHistory(List<List<Car>> raceHistory) {
        System.out.println("실행 결과");
        for (List<Car> round : raceHistory) {
            for (Car car : round) {
                System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }
    }

    public void printWinners(List<Car> winners) {
        String names = String.join(", ",
                winners.stream().map(Car::getCarName).toList());
        System.out.println(RESULT_MSG + names);
    }
}
