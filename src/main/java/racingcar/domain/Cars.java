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

    public Cars(List<Car> cars, List<String> races) {
        this.cars = cars;
        this.races = races;
    }

    public static Cars of(List<String> inputCarNames) {
        List<Car> cars = inputCarNames
                .stream()
                .filter(s -> !s.isBlank())
                .map(Car::new)
                .toList();
        return new Cars(cars, new ArrayList<>());
    }

    public void runRace(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars.stream()
                    .filter(car -> car.pickNumber() >= GO_THRESHOLD)
                    .forEach(Car::go);

            StringBuilder steps = new StringBuilder();
            cars.stream()
                    .map(Car::getStepsResult)
                    .forEach(steps::append);

            races.add(steps.toString());
        }
    }

    public String getRace(int i) {
        return races.get(i);
    }

    public int getWinnerSteps() {
        Optional<Car> winnerCar = cars
                .stream()
                .max(Comparator.comparing(car -> car.raceCount));
        if (winnerCar.isEmpty()) {
            throw new IllegalArgumentException(NO_CAR_ERROR.getErrorMessage()); // 자동차 없음
        }
        return winnerCar.get().raceCount;
    }

    public String getWinners(int winnerSteps) {
        List<Car> winnersList = getWinnersList(winnerSteps);

        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < winnersList.size(); i++) {
            String race = winnersList.get(i).name;
            winners.append(race);
            if (i != winnersList.size() - 1) {
                winners.append(", ");
            }
        }

        return winners.toString();
    }

    private List<Car> getWinnersList(int winnerSteps) {
        return cars.stream()
                .filter(car -> car.raceCount == winnerSteps)
                .toList();
    }

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
