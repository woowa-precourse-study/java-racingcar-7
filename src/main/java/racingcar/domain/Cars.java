package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static racingcar.constant.Constant.*;
import static racingcar.constant.ErrorMessage.*;

public class Cars {
    private final List<Car> cars;
    private final List<String> races;

    private Cars(List<Car> cars, List<String> races) {
        this.cars = cars;
        this.races = races;
    }

    // 자동차 리스트 생성 및 반환
    public static Cars of(List<String> inputCarNames) {
        List<Car> cars = inputCarNames
                .stream()
                .filter(s -> !s.isBlank())
                .map(Car::new)
                .toList();
        return new Cars(cars, new ArrayList<>());
    }

    // 자동차 경주 진행
    public void runRace(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars.stream()
                    .filter(car -> car.pickNumber() >= GO_THRESHOLD)
                    .forEach(Car::go);

            // 진행 과정 출력 문자열 저장
            // 성능 최적화를 위해 StringBuilder 사용
            StringBuilder steps = new StringBuilder();
            cars.stream()
                    .map(Car::getStepsResult)
                    .forEach(steps::append);

            races.add(steps.toString());
        }
    }

    // 각 라운드 진행 과정 출력 문자열 반환 -> OutputView 에서 호출
    public String getRace(int i) {
        return races.get(i);
    }

    // 우승자 step 개수 반환
    public int getWinnerSteps() {
        Optional<Car> winnerCar = cars
                .stream()
                .max(Comparator.comparing(car -> car.raceCount));
        if (winnerCar.isEmpty()) {
            throw new IllegalArgumentException(NO_CAR_ERROR.getErrorMessage()); // 자동차 없음
        }
        return winnerCar.get().raceCount;
    }

    // 우승자 출력 문자열 반환
    public String getWinners(int winnerSteps) {
        List<Car> winnersList = getWinnersList(winnerSteps);

        List<String> winners = winnersList
                .stream()
                .map(car -> car.name)
                .toList();

        return String.join(", ", winners);
    }

    // 우승자 리스트 반환
    private List<Car> getWinnersList(int winnerSteps) {
        return cars.stream()
                .filter(car -> car.raceCount == winnerSteps)
                .toList();
    }

    // Cars 에서만 사용하는 Car 클래스
    public static class Car {
        private final String name;
        private String steps;
        private int raceCount;
        private static final String STEP = "-";

        public Car(String name) {
            this.name = name;
            steps = "";
        }

        public String getStepsResult() {
            return name + " : " + steps + "\n";
        }

        public int pickNumber() {
            return Randoms.pickNumberInRange(RANDOM_FROM, RANDOM_TO);
        }

        public void go() {
            steps += STEP;
            raceCount++;
        }
    }
}
